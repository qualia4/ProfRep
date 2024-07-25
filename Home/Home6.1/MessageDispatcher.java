import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Consumer;

class MessageDispatcher {
    private final Map<Class<? extends Message>, List<Subscription<? extends Message>>> subscribers = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public <T extends Message> UUID subscribe(Class<T> messageType, Consumer<T> callback) {
        Subscription<T> subscription = new Subscription<>(callback);
        subscribers.computeIfAbsent(messageType, k -> new CopyOnWriteArrayList<>()).add(subscription);
        return subscription.getId();
    }

    public boolean unsubscribe(UUID subscriptionId) {
        for (List<Subscription<? extends Message>> subscriptionList : subscribers.values()) {
            if (subscriptionList.removeIf(sub -> sub.getId().equals(subscriptionId))) {
                return true;
            }
        }
        return false;
    }

    public <T extends Message> void publish(T message) {
        List<Subscription<? extends Message>> subscriptionList = subscribers.get(message.getClass());
        if (subscriptionList != null) {
            for (Subscription<? extends Message> subscription : subscriptionList) {
                executorService.submit(() -> ((Subscription<T>) subscription).notify(message));
            }
        }
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

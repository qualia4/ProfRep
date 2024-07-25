import java.util.UUID;
import java.util.function.Consumer;

class Subscription<T extends Message> {
    private final UUID id;
    private final Consumer<T> callback;

    public Subscription(Consumer<T> callback) {
        this.id = UUID.randomUUID();
        this.callback = callback;
    }

    public UUID getId() {
        return id;
    }

    public void notify(T message) {
        callback.accept(message);
    }
}

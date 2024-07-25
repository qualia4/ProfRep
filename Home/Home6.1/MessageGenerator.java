import java.util.Random;

class MessageGenerator implements Runnable {
    private final MessageDispatcher dispatcher;
    private final Random random = new Random();

    public MessageGenerator(MessageDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                dispatcher.publish(generateRandomMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private Message generateRandomMessage() {
        switch (random.nextInt(3)) {
            case 0:
                return new GreenMessage("Green content " + random.nextInt(100), random.nextInt(1000));
            case 1:
                return new BlueMessage(random.nextDouble(), random.nextDouble());
            default:
                return new OrangeMessage("Orange string 1", "Orange string 2", random.nextInt(100), random.nextDouble());
        }
    }
}
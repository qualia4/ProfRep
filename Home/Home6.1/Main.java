import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MessageDispatcher dispatcher = new MessageDispatcher();

        // Subscribe to messages
        UUID greenSub = dispatcher.subscribe(GreenMessage.class, msg -> System.out.println("Received Green: " + msg));
        UUID blueSub = dispatcher.subscribe(BlueMessage.class, msg -> System.out.println("Received Blue: " + msg));
        UUID orangeSub = dispatcher.subscribe(OrangeMessage.class, msg -> System.out.println("Received Orange: " + msg));

        // Start message generators
        ExecutorService generatorService = Executors.newFixedThreadPool(2);
        generatorService.submit(new MessageGenerator(dispatcher));
        generatorService.submit(new MessageGenerator(dispatcher));

        // Run for some time
        Thread.sleep(5000);

        // Unsubscribe from GreenMessage
        dispatcher.unsubscribe(greenSub);
        System.out.println("Unsubscribed from GreenMessage");

        // Run for some more time
        Thread.sleep(5000);

        // Shutdown
        generatorService.shutdownNow();
        dispatcher.shutdown();
    }
}
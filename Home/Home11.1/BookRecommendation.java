import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BookRecommendation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the customer's name
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        List<String> books = new ArrayList<>(List.of(
                "The Topographer's Clown",
                "The Chamber of Beaver",
                "The Ironer of Kanban",
                "The Piglet of Tire",
                "The Border of the Unix",
                "The Half-Time Convince",
                "The Earthly Pillows",
                "The Censorship of the Ping",
                "The True Powers",
                "The Overturn of the Ling"
        ));

        Random random = new Random();

        while (!books.isEmpty()) {
            int index = random.nextInt(books.size());
            String recommendation = books.get(index);

            System.out.println("How about: " + recommendation + "?");
            System.out.print("Do you like this recommendation? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();

            if (response.equals("yes")) {
                System.out.println("Great! Enjoy your book!");
                System.out.println("Au revoir, " + name);
                return;
            } else {
                books.remove(index);
            }
        }

        System.out.println("Adios amigo!");
        scanner.close();
        System.exit(1);  // Crash the program
    }
}
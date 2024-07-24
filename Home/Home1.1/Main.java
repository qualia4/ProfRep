import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Do you want to continue? (Y/N): ");
            if(!scanner.next().toLowerCase().equals("y")){
                scanner.close();
                return;
            }
            double[] coefficients = getCoefficients(scanner);
            double discriminant = calculateDiscriminant(coefficients[0], coefficients[1], coefficients[2]);
            double[] roots = calculateRoots(coefficients[0], coefficients[1], discriminant);
            printRoots(roots);
        }
    }

    public static double[] getCoefficients(Scanner scanner) {
        double[] coefficients = new double[3];

        System.out.print("Enter coefficient a: ");
        coefficients[0] = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        coefficients[1] = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        coefficients[2] = scanner.nextDouble();

        return coefficients;
    }

    public static double calculateDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static double[] calculateRoots(double a, double b, double discriminant) {
        double[] roots = new double[3];
        roots[0] = discriminant;
        if (discriminant > 0) {
            roots[1] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[2] = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            roots[1] = -b / (2 * a);
            roots[2] = Double.NaN; // No second root
        } else {
            roots[1] = -b / (2 * a);
            roots[2] = Math.sqrt(-discriminant) / (2 * a); // Imaginary part
        }
        return roots;
    }

    public static void printRoots(double[] roots) {
        double discriminant = roots[0];
        if (discriminant > 0) {
            System.out.printf("Root 1 = %.2f and Root 2 = %.2f%n", roots[1], roots[2]);
        } else if (discriminant == 0) {
            System.out.printf("Root = %.2f%n", roots[1]);
        } else {
            System.out.printf("Root 1 = %.2f + %.2fi and Root 2 = %.2f - %.2fi%n",
                    roots[1], roots[2], roots[1], roots[2]);
        }
    }
}

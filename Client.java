import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to the RMI registry on localhost and port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object using the same name registered by the server
            ArithmeticService service = (ArithmeticService) registry.lookup("ArithmeticService");

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n---- Arithmetic Menu ----");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                if (ch == 5) break;

                System.out.print("Enter number 1: ");
                int a = sc.nextInt();
                System.out.print("Enter number 2: ");
                int b = sc.nextInt();

                switch (ch) {
                    case 1 -> System.out.println("Result: " + service.add(a, b));
                    case 2 -> System.out.println("Result: " + service.subtract(a, b));
                    case 3 -> System.out.println("Result: " + service.multiply(a, b));
                    case 4 -> System.out.println("Result: " + service.divide(a, b));
                    default -> System.out.println("Invalid choice!");
                }
            }

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

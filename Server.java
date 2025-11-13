import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Arithmetic Server started...");

            // Create an instance of the service
            ArithmeticService service = new ArithmeticServiceImpl();

            // Register (bind) the service in the registry with the name "ArithmeticService"
            registry.rebind("ArithmeticService", service);

            System.out.println("Server is ready!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

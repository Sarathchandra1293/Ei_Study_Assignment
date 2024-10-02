import java.util.Scanner;

class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your log message (type 'exit' to quit): ");
        String message = scanner.nextLine();

        if (!message.equalsIgnoreCase("exit")) {
            logger.log(message);
        } else {
            System.out.println("Exiting the application.");
        }

        scanner.close();
    }
}

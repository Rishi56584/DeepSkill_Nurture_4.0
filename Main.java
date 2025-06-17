// Main.java

class Logger {
    // Step 1: Create private static instance
    private static Logger instance;

    // Step 2: Make the constructor private
    private Logger() {
        System.out.println("Logger Initialized.");
    }

    // Step 3: Provide a public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A sample log method
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}


public class Main {
    public static void main(String[] args) {
        // Test the singleton
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Starting the application...");
        logger2.log("This is another log message.");

        // Verify both references are same
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (singleton verified).");
        } else {
            System.out.println("Logger is not a singleton!");
        }
    }
}

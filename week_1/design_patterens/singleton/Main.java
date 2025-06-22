package singleton;
class Logger {
    private static volatile Logger instance;

    private Logger() {
        System.out.println("Logger Initialized.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Starting the application...");
        logger2.log("This is another log message.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (singleton verified).");
        } else {
            System.out.println("Logger is not a singleton!");
        }
    }
}
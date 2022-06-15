package ge.tsu.logger;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger() {
        super(System.out);
    }

    public ConsoleLogger(Level defaultLevel) {
        this();
        setDefaultLevel(defaultLevel);
    }

    @Override
    public void print(Level level, String message, Object... args) {
        super.print(level, message, args);
    }
}

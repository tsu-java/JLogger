package ge.tsu.logger;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(String name) {
        super(name, System.out);
    }

    public <T> ConsoleLogger(Class<T> aClass) {
        super(aClass, System.out);
    }

    public ConsoleLogger(String name, Level defaultLevel) {
        this(name);
        setDefaultLevel(defaultLevel);
    }

    public <T> ConsoleLogger(Class<T> aClass, Level defaultLevel) {
        this(aClass);
        setDefaultLevel(defaultLevel);
    }
}

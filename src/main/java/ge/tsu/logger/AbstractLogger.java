package ge.tsu.logger;

import java.io.PrintStream;

public abstract class AbstractLogger implements Logger {

    private Formatter formatter = new Formatter();

    private Level defaultLevel = Level.INFO;
    private PrintStream printStream;

    public AbstractLogger(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void print(Level level, String message, Object... args) {
        if (getDefaultLevel().ordinal() <= level.ordinal()) {
            printStream.print(
                    formatter.format(level, message, args)
            );
        }
    }

    @Override
    public void trace(String message, Object... args) {
        print(Level.TRACE, message, args);
    }

    @Override
    public void debug(String message, Object... args) {
        print(Level.DEBUG, message, args);
    }

    @Override
    public void info(String message, Object... args) {
        print(Level.INFO, message, args);
    }

    @Override
    public void warn(String message, Object... args) {
        print(Level.WARN, message, args);
    }

    @Override
    public void error(String message, Object... args) {
        print(Level.ERROR, message, args);
    }

    @Override
    public void fatal(String message, Object... args) {
        print(Level.FATAL, message, args);
    }

    @Override
    public Level getDefaultLevel() {
        return defaultLevel;
    }

    @Override
    public void setDefaultLevel(Level defaultLevel) {
        this.defaultLevel = defaultLevel;
    }

    @Override
    public PrintStream getPrintStream() {
        return printStream;
    }

    @Override
    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public String getPattern() {
        return formatter.getPattern();
    }

    @Override
    public void setPattern(String pattern) {
        formatter.setPattern(pattern);
    }
}

package ge.tsu.logger;

import java.io.PrintStream;

public abstract class AbstractLogger implements Logger {

    private Level defaultLevel = Level.INFO;
    private PrintStream printStream = System.out;
    private boolean endWithNewLine = true;

    public AbstractLogger(PrintStream printStream) {
        this.printStream = printStream;
    }

    public AbstractLogger(Level defaultLevel) {
        this.defaultLevel = defaultLevel;
    }

    public AbstractLogger(boolean endWithNewLine) {
        this.endWithNewLine = endWithNewLine;
    }

    public AbstractLogger(Level defaultLevel, PrintStream printStream) {
        this.defaultLevel = defaultLevel;
        this.printStream = printStream;
    }

    public AbstractLogger(Level defaultLevel, boolean endWithNewLine) {
        this.defaultLevel = defaultLevel;
        this.endWithNewLine = endWithNewLine;
    }

    public AbstractLogger(PrintStream printStream, boolean endWithNewLine) {
        this.printStream = printStream;
        this.endWithNewLine = endWithNewLine;
    }

    @Override
    public void print(Level level, String message, Object... args) {
        if (getDefaultLevel().ordinal() <= level.ordinal()) {
            StringBuilder sb = new StringBuilder(message);
            if (isEndWithNewLine()) {
                sb.append('\n');
            }
            printStream.printf(sb.toString(), args);
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
    public boolean isEndWithNewLine() {
        return endWithNewLine;
    }

    @Override
    public void setEndWithNewLine(boolean endWithNewLine) {
        this.endWithNewLine = endWithNewLine;
    }

}

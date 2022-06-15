package ge.tsu.logger;

import java.io.PrintStream;

public interface Logger {

    void print(Level level, String message, Object... args);

    void trace(String message, Object... args);

    void debug(String message, Object... args);

    void info(String message, Object... args);

    void warn(String message, Object... args);

    void error(String message, Object... args);

    void fatal(String message, Object... args);

    String getName();

    void setName(String name);

    Level getDefaultLevel();

    void setDefaultLevel(Level defaultLevel);

    PrintStream getPrintStream();

    void setPrintStream(PrintStream printStream);

    String getPattern();

    void setPattern(String pattern);
}

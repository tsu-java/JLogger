package ge.tsu.logger;

import java.io.FileOutputStream;

public class FileLogger extends AbstractLogger {

    public FileLogger(String name, FileOutputStream fileOutputStream) {
        super(name, fileOutputStream);
    }

    public <T> FileLogger(Class<T> aClass, FileOutputStream fileOutputStream) {
        super(aClass, fileOutputStream);
    }

    public FileLogger(String name, Level defaultLevel, FileOutputStream fileOutputStream) {
        this(name, fileOutputStream);
        setDefaultLevel(defaultLevel);
    }

    public <T> FileLogger(Class<T> aClass, Level defaultLevel, FileOutputStream fileOutputStream) {
        this(aClass, fileOutputStream);
        setDefaultLevel(defaultLevel);
    }
}

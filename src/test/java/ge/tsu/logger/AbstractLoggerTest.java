package ge.tsu.logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AbstractLoggerTest {

    private Logger logger;
    private PrintStream printStream;
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(byteArrayOutputStream, true);
        logger = new AbstractLogger(printStream, false) {
        };
    }

    @AfterEach
    void tearDown() {
        if (printStream != null) {
            try {
                printStream.close();
            } catch (Exception e) {
            }
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
        }
    }

    @ParameterizedTest
    @EnumSource(names = {"TRACE", "DEBUG", "INFO", "WARN", "ERROR", "FATAL"})
    void print(Level level) {
        logger.setDefaultLevel(level);
        logger.print(level, "Testing level %s message!", level);
        String actualMessage = byteArrayOutputStream.toString();
        Assertions.assertEquals(String.format("Testing level %s message!", level), actualMessage);
    }
}
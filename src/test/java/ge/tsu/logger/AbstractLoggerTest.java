package ge.tsu.logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void print() {
        logger.setDefaultLevel(Level.INFO);
        logger.print(Level.INFO, "Testing level info message");
        String actualMessage = byteArrayOutputStream.toString();
        Assertions.assertEquals("Testing level info message", actualMessage);
    }
}
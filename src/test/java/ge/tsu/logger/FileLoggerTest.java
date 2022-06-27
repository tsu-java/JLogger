package ge.tsu.logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileLoggerTest {

    private Logger logger;
    private FileOutputStream fileOutputStream;
    private Path tmpFilePath;

    @BeforeEach
    void setUp() throws IOException {
        tmpFilePath = Files.createTempFile("test", ".log");
        fileOutputStream = new FileOutputStream(tmpFilePath.toFile());
        logger = new FileLogger("Test file logger", fileOutputStream);
        logger.setPattern("%message%");
    }

    @AfterEach
    void tearDown() {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
            }
        }
    }

    @Test
    void print() throws IOException {
        logger.setDefaultLevel(Level.INFO);
        logger.info("Testing message: %s", "Hey there!");
        String fileContent = Files.readString(tmpFilePath);
        assertEquals(String.format("Testing message: %s", "Hey there!"), fileContent);
    }

}

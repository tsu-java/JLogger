package ge.tsu.logger;

public class Formatter {

    private static final String LEVEL_PATTERN = "%level%";
    private static final String MESSAGE_PATTERN = "%message%";
    private static final String NEWLINE_PATTERN = "%n%";

    private String pattern = "[%level%]: %message%%n%";

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String format(Level level, String message, Object... args) {
        if (args.length > 0) {
            message = String.format(message, args);
        }
        StringBuilder sb = new StringBuilder(pattern);

        int levelIndex;
        while ((levelIndex = sb.indexOf(LEVEL_PATTERN)) != -1) {
            sb.replace(levelIndex, levelIndex + LEVEL_PATTERN.length(), level.name());
        }

        int messageIndex;
        while ((messageIndex = sb.indexOf(MESSAGE_PATTERN)) != -1) {
            sb.replace(messageIndex, messageIndex + MESSAGE_PATTERN.length(), message);
        }

        int newLineIndex;
        while ((newLineIndex = sb.indexOf(NEWLINE_PATTERN)) != -1) {
            sb.replace(newLineIndex, newLineIndex + NEWLINE_PATTERN.length(), "\n");
        }

        return sb.toString();
    }
}

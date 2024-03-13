package Utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final Logger logger = Logger.getLogger(Log.class.getName());

    static {
        // Remove the default console handler
        logger.setUseParentHandlers(false);

        // Create a new console handler
        ConsoleHandler handler = new ConsoleHandler();

        // Customize the log formatter to output messages with white or green colors
        ColoredLogFormatter formatter = new ColoredLogFormatter();
        handler.setFormatter(formatter);

        // Add the custom console handler
        logger.addHandler(handler);
    }

    public static Logger getCurrentLog() {
        return logger;
    }

    public static void info(String msg) {
        getCurrentLog().log(Level.INFO, msg);
    }

    public static void error(String msg) {
        getCurrentLog().log(Level.SEVERE, msg);
    }

    // Custom log formatter to output messages with white or green colors and include timestamp
    private static class ColoredLogFormatter extends java.util.logging.Formatter {
        @Override
        public String format(java.util.logging.LogRecord record) {
            StringBuilder builder = new StringBuilder();
            String color;
            if (record.getLevel() == Level.SEVERE) {
                color = "\u001B[31m"; // Red color for SEVERE messages
            } else {
                color = "\u001B[32m"; // Green color for INFO messages
            }
            builder.append(color); // Apply color
            builder.append("["); // Start of log message
            builder.append(record.getLevel().getName()); // Log level
            builder.append(" : "); // Separator
            builder.append(LocalDateTime.now().format(formatter)); // Log level
            builder.append("] "); // Separator
            builder.append(formatMessage(record)); // Log message
            builder.append("\n"); // Newline
            builder.append("\u001B[0m"); // Reset color
            return builder.toString();
        }
    }
}
package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

class ExceptionLogger {
    private static final String LOG_FILE = "lab4/log.txt";
    
    public static void logException(Exception e) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(LocalDateTime.now() + " - " + e.getClass().getSimpleName() + ": " + e.getMessage() + "\n");
            System.out.println("Исключение логировано.");
        } catch (IOException ex) {
            System.out.println("Ошибка при логировании: " + ex.getMessage());
        }
    }
}

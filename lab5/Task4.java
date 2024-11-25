import java.util.regex.*;

public class Task4 {
    public static void main(String[] args) {
        try {
            String ip = "127.0.256.1";

            // Регулярное выражение для проверки IP-адреса
            String oneNum = "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])";
            String ipPattern = "^("+ oneNum +"\\.){3}"+ oneNum +"$";
            Pattern pattern = Pattern.compile(ipPattern);
            Matcher matcher = pattern.matcher(ip);
    
            if (matcher.matches()) {
                System.out.println("IP-адрес корректен.");
            } else {
                System.out.println("Некорректный IP-адрес. Убедитесь, что адрес состоит из четырех чисел от 0 до 255, разделенных точками.");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}

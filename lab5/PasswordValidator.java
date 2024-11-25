import java.util.Scanner;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();
            
            // Регулярное выражение для проверки пароля
            String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)//w{8,16}$";
            Pattern pattern = Pattern.compile(passwordPattern);
            Matcher matcher = pattern.matcher(password);
            
            if (matcher.matches()) {
                System.out.println("Пароль корректен.");
            } else {
                System.out.println("Пароль некорректен. Убедитесь, что он состоит из латинских букв и цифр, длиной от 8 до 16 символов, содержит хотя бы одну заглавную букву и одну цифру.");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }
}

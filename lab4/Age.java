package lab4;

import java.util.Scanner;

public class Age {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        // int age = 130; 1000
        try {
            validateAge(age);
            System.out.println("Возраст " + age + " корректен.");
            // int a = 0/0;
        } catch (CustomAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);
        } finally {
            scanner.close();
        }
    }
    
    public static void validateAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Возраст должен быть в диапазоне от 0 до 120 лет.");
        }
    } 
}

package lab4;

public class ArrayAverage {
 
    public static void main(String[] args) { 
        Object[] arr = {1, 2, 3, 4, "hfhjif"};
        int sum = 0;
        
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += (int) arr[i];
            }

            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);

        } catch (ClassCastException e) {
            System.out.println("Ошибка: нечисловые данные - " + e.getMessage()); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: выход за границы массива"+" - " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль" + " - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}

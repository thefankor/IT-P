import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            String text = " 1. The price of the product is $-19.99";
        
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);
            
            System.out.println("Найденные числа:");
            
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}

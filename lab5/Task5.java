import java.util.regex.*;

public class Task5 {
    public static void main(String[] args) {
        try {
            char letter = 't';
            String text = "The price of the product is $19.99, and the discount is 5. Total is 25 dollars.";
            
            Pattern pattern = Pattern.compile("\\b(?i)"+letter+"[A-Za-z]*\\b");
            Matcher matcher = pattern.matcher(text);
            
            System.out.println("Найденные слова:");
            
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
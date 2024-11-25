import java.util.regex.*;

public class Task3 {
    public static void main(String[] args) {
        try {
            String text = "The quick bRown fox Jumps over the lazy dOg"; 
            Pattern pattern = Pattern.compile("([a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);
    
            String newStr = matcher.replaceAll("!$1$2!");
            
            System.out.println(newStr);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
   
}

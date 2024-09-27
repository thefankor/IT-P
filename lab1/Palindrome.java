package lab1;

public class Palindrome {
    public static void main(String[] args) { 
        for (int i = 0; i < args.length; i++) {
            String s = args[i]; 
            System.out.println(s);
            System.out.println(isPalindrome(s));
            System.out.print("\n");
        }
    }

    public static String reverseString(String s) {
        String newStr = "";
        for (int x = s.length()-1; x >= 0; x--) {
            newStr += s.charAt(x);
            // if (s.charAt(0) == 'a') return "";
        }
        return newStr;
    }

    public static Boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}
    
import java.util.Arrays;
import java.util.HashMap;

public class Task3 {
    public static void main(String args[]) {
        System.out.println(isStrangePair("ratio", "orator"));

        Object[][] products = new Object[][] {
            {"Laptop", 124200},
            {"Phone", 51450},
            {"Headphones", 13800},
        };
        Object[][] result = sale(products, 25);
        for (Object[] product : result) {
            System.out.println(Arrays.toString(product));
        }

        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));
        System.out.println(parityAnalysis(243));
        System.out.println(rps("rock", "rock"));
        System.out.println(bugger(9999));

        Object[][] inventory = new Object[][] {
            {"Скакалка", 550, 8},
            {"Шлем", 3750, 4},
            {"Мяч", 2900, 10}
        };
        System.out.println(mostExpensive(inventory));
        System.out.println(longestUnique("abcba"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
    }

    //1
    public static boolean isStrangePair(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            if (s1.length() == 0 && s2.length() == 2) return true;
            return false;
        }

        if (s1.charAt(0) == s2.charAt(s2.length()-1) && s1.charAt(s1.length()-1) == s2.charAt(0)) {
            return true;
        }
        return false;
    }

    //2
    public static Object[][] sale(Object[][] products, int discount) {
        Object[][] result = new Object[products.length][2];
        for (int i = 0; i < products.length; i++) {
            Object[] product = products[i];
            String name = (String) product[0];
            int price = (int) product[1];
            int newPrice = price - (price * discount / 100);
            newPrice = Math.max(1, Math.round(newPrice));
            result[i] = new Object[] {name, newPrice};
        }
        return result;
    }

    //3
    public static boolean sucsessShoot(int x, int y, int r, int m, int n) {
        if ( (m - x) * (m - x) + (n - y) * (n - y) <= r*r ) return true;
        return false;
    }

    //4
    public static boolean parityAnalysis(int x) {
        int sum = 0;
        int x2 = x % 2;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum%2 == x2;
    }

    //5
    public static String rps(String p1, String p2) {
        if (p1.equals(p2) ) return "tie";
        if ((p1 == "rock" && p2 == "scissors") || (p1 == "paper" && p2 == "rock") || (p1 == "scissors" && p2 == "paper")) {
            return "Player 1 wins";
        } return "Player 2 wins";
    }

    //6
    public static int bugger(int x) {
        int count = 0;
        int new_x = 1;
        while (x >= 10) {
            while (x > 0) {
                new_x *= x%10;
                x /= 10;
            }
            count++;
            x = new_x;
            new_x = 1;
        }
        return count;
    }

    //7
    public static String mostExpensive(Object[][] inv) {
        int maxPrice = 0;
        String maxPriceItem = "";

        for (int i = 0; i < inv.length; i++) {
            Object[] inventory = inv[i];
            String name = (String) inventory[0];
            int price = (int) inventory[1];
            int count = (int) inventory[2];
            int total = price * count;
            if (total > maxPrice) {
                maxPrice = total;
                maxPriceItem = name;
            }
        }
        return "Наиб. общ. стоимость у предмета " + maxPriceItem + " - " + maxPrice;
    }

    //8
    public static String longestUnique(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        String longestSubstring = "";
        int start = 0;
        
        for (int end = 0; end < str.length(); end++) {
            char currentChar = str.charAt(end);

            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }

            charIndexMap.put(currentChar, end);

            if (end - start + 1 > longestSubstring.length()) {
                longestSubstring = str.substring(start, end + 1);
            }
        }
        return longestSubstring;
    }

    //9
    public static boolean isPrefix(String s, String prefix) {
        prefix = prefix.replace("-", "");
        return s.startsWith(prefix);
    }
    public static boolean isSuffix(String s, String suffix) {
        suffix = suffix.replace("-", "");
        return s.endsWith(suffix);
    }

    //10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return  (a <= w && b <= h) || (a <= h && b <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w);
    }

}

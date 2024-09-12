package lab1;

public class Prime {
    public static void main(String args[]) {
        
        for (int n = 2; n<=100; n++) {
            if (isPrime(n)) System.out.println(n);
        }
    }
    public static boolean isPrime(int n) {
        for (int x = 2; x<n; x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }
}


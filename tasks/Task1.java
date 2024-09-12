public class Task1 {
    public static void main(String args[]) {
        System.out.println(convert(8));
        System.out.println(fitCalc(10, 2));
        System.out.println(containers(3, 4, 2));
        System.out.println(triangleType(5, 5, 5));
        System.out.println(ternaryEvaluation(100, 90));
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(factorial(5));
        System.out.println(qcd(48, 18));
        System.out.println(ticketSaler(53, 1250));
        System.out.println(tables(123, 58));
    }

    public static double convert(int n) {
        return n * 3.785;
    }

    public static int fitCalc(int min, int i) {
        return min * i;
    }

    public static int containers(int boxes, int bag, int barrel) {
        return boxes*20 + bag*50 + barrel*100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "не является треугольником";
        }

        String type;
        if (x == y && y == z) {
            type = "равносторонний";
        } else if (x == y || y == z || x == z) {
            type = "равнобедренный";
        } else {
            type = "разносторонний";
        }
        return type;
    }

    public static int ternaryEvaluation(int a, int b) {
        return  a > b ? a:b;
    }

    public static int howManyItems(double n, double w, double h) {
        int count = (int) (n / (h*w*2));
        return count;
    }

    public static int factorial(int x) {
        int f = 1;
        for (int n=2;n<=x;n++) {
            f = f * n;
        }
        return f;
    }

    public static int qcd(int a, int b) {
        if (b % a == 0) {
            return a;
        }
        return qcd(b, a % b);
    }

    public static double ticketSaler(int count, int price) {
        return count*price - 0.28*count*price;
    }

    public static int tables(int stud, int table) {
        int needTables = stud / 2;
        if (stud % 2 != 0) needTables++;
        if (table >= needTables) return 0;
        return needTables - table;
    }
} 

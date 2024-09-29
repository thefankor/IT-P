import java.util.Arrays;
public class Task2 {
    public static void main(String args[]) {
        System.out.println(duplicateChars("Barack", "Obama"));
        int[] arr = {3,12,7,81,52};
        System.out.println(dividedByThree(arr));
        System.out.println(getInitials("simonov sergei evgenievich"));
        double[] arr2 = {3.5, 7.0, 1.5, 9.0, 5.5};
        // normalizator(arr2);
        System.out.println(Arrays.toString(normalizator(arr2)));
        double[] arr3 = {1.6, 0, 212.3, 34.8, 0, 27.5};
        System.out.println(Arrays.toString(compressedNums(arr3)));
        System.out.println(camelToSnake("helloMyWorld"));
        int[] arr4 = {3, 5, 8, 1, 2, 4};
        System.out.println(secondBiggest(arr4));
        System.out.println(localReverse("Hello, I'm under the water, please help me", 'e'));
        System.out.println(equal(8, 1, 8));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
    }

    public static String duplicateChars(String s1, String s2) {
        String result = "";
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!s2.contains(String.valueOf(c)) && !result.contains(String.valueOf(c))) {
                result += c;
            }
            
        }
        return result;
    }

    public static int dividedByThree(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i]%3 == 0) count++;
        }
        return count;
    }

    public static String getInitials(String fio) {
        String newfio = "";
        String arr[] = fio.split(" ");
        for (int i = 1; i < arr.length; i++) {
            newfio += arr[i].toUpperCase().charAt(0) + ".";
        }
        newfio += arr[0].toUpperCase().charAt(0) + arr[0].substring(1);
        return newfio;
    }

    public static double[] normalizator(double[] arr) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] - min) / (max - min);
            // System.out.println(arr[i]);
        }
        return arr;
    }

    public static int[] compressedNums(double arr[]) {
        int notZeroCount = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i]!=0) notZeroCount++;
        int[] newArr = new int[notZeroCount];
        int index = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i]!=0) {
            newArr[index] = (int) arr[i];
            index++;
        }
        Arrays.sort(newArr);
        return newArr;
    }

    public static String camelToSnake(String s) {
        String snakeCase = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                snakeCase+= "_" + s.toLowerCase().charAt(i);
            } else {
                snakeCase+= s.charAt(i);
            };
        }
        return snakeCase;
    }

    public static int secondBiggest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int preMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                preMax = max; 
                max = arr[i];        
            } else if (arr[i] > preMax && arr[i] != max) {
                preMax = arr[i];   
            }
        }
        return preMax;
    }

    public static String localReverse(String str, char marker) {
        String newStr = "";
        int start = -1;
        int end = -1;
        boolean pre = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == marker) {
                pre = false;
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                    newStr += marker;
                    for (int e = end-1; e > start; e--) {
                        newStr += str.charAt(e);
                    }
                    newStr += marker;
                    start = -1; }
            } else if (pre || start == -1) {
                newStr += str.charAt(i);
            }
        }
        if (start!=-1) {
            for (int s = start; s < str.length(); s++) {
                newStr += str.charAt(s);
            }
        }
        return newStr;
    }

    public static int equal(int a, int b, int c) {
        if (a==b && b==c) {
            return 3;
        } else if (a == b || b == c || a == c) {
            return 2;
        } return 0;
    }
    public static boolean isAnagram(String str1, String str2) {
        char[] charArray1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        char[] charArray2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}
    

// https://github.com/thefankor/IT-P
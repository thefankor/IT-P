import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task5 {
    public static void main(String[] args) {
        // System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(memeSum(260, 39));
        // System.out.println(digitsCount(4666));
        // System.out.println(totalPoints(Arrays.asList("dote", "dotes", "toes", "set", "dot", "dots", "sted"), "tossed"));
        // System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));
        // System.out.println(takeDownAverage(Arrays.asList("95%", "83%", "90%", "87%", "88%", "93%")));
        // System.out.println(canMove("Rook", "A8", "H8"));
        // System.out.println(maxPossible(9328, 456));
        // System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        // System.out.println(isNew(100234708));
    }


    //1
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if (map1.put(str1.charAt(i), i) != map2.put(str2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    //2
    public static int memeSum(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        
        int maxLength = Math.max(str1.length(), str2.length());

        str1 = String.format("%" + maxLength + "s", str1).replace(' ', '0');
        str2 = String.format("%" + maxLength + "s", str2).replace(' ', '0');

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            int digitSum = (str1.charAt(i) - '0') + (str2.charAt(i) - '0');
            result.append(digitSum);
        }
        return Integer.parseInt(result.toString());
    }

    //3
    public static int digitsCount(int num) {
        if (num == 0) return 1;
        if (num < 10) return 1;
        return 1 + digitsCount(num / 10);
    }

    //4
    public static int totalPoints(List<String> guessedWords, String scrambledWord) {
        Map<Character, Integer> scrambledCount = getCharCount(scrambledWord);
        
        int totalPoints = 0;

        for (String word : guessedWords) {
            if (canFormWord(word, scrambledCount)) {
                int points = 0;
                switch (word.length()) {
                    case 3:
                        points = 1;
                        break;
                    case 4:
                        points = 2;
                        break;
                    case 5:
                        points = 3;
                        break;
                    case 6:
                        points = 4 + 50;
                        break;
                }
                totalPoints += points;
            }
        }

        return totalPoints;
    }

    private static Map<Character, Integer> getCharCount(String word) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    private static boolean canFormWord(String word, Map<Character, Integer> scrambledCount) {
        Map<Character, Integer> wordCount = getCharCount(word);
        
        for (Map.Entry<Character, Integer> entry : wordCount.entrySet()) {
            if (scrambledCount.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    //5
    public static int longestRun(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int maxLength = 1; 
        int currentLength = 1; 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1 || arr[i] == arr[i - 1] - 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    //6
    public static String takeDownAverage(List<String> grades) {
        int total = 0;
        for (String grade : grades) {
            total += Integer.parseInt(grade.replace("%", ""));
        }

        int n = grades.size();
        double currentAverage = total / (double) n;
        double targetAverage = currentAverage * 0.95;
        double requiredGrade = (targetAverage * (n + 1)) - total;

        return Math.round(requiredGrade) + "%";
    }

    //7
    public static boolean canMove(String piece, String start, String end) {
        int[] startPos = positionToIndices(start);
        int[] endPos = positionToIndices(end);

        int startX = startPos[0];
        int startY = startPos[1];
        int endX = endPos[0];
        int endY = endPos[1];

        switch (piece.toLowerCase()) {
            case "pawn":
                if (startX == endX && Math.abs(startY - endY) == 1) {
                    return true;
                }
                if (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 1) {
                    return true;
                }
                break;
            case "knight":
                if ((Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 1) ||
                    (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 2)) {
                    return true;
                }
                break;
            case "bishop":
                if (Math.abs(startX - endX) == Math.abs(startY - endY)) {
                    return true;
                }
                break;
            case "rook":
                if (startX == endX || startY == endY) {
                    return true;
                }
                break;
            case "queen":
                if (Math.abs(startX - endX) == Math.abs(startY - endY) || startX == endX || startY == endY) {
                    return true;
                }
                break;
            case "king":
                if (Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static int[] positionToIndices(String position) {
        int col = position.charAt(0) - 'A';
        int row = 8 - Integer.parseInt(position.substring(1));
        return new int[]{col, row};
    }

    //8
    public static int maxPossible(int num1, int num2) {
        String num1Str = String.valueOf(num1);
        String num2Str = String.valueOf(num2);

        char[] num1Chars = num1Str.toCharArray();
        char[] num2Chars = num2Str.toCharArray();
        
        java.util.Arrays.sort(num2Chars);
        for (int i = 0; i < num2Chars.length / 2; i++) {
            char temp = num2Chars[i];
            num2Chars[i] = num2Chars[num2Chars.length - 1 - i];
            num2Chars[num2Chars.length - 1 - i] = temp;
        }

        int j = 0; 

        for (int i = 0; i < num1Chars.length && j < num2Chars.length; i++) {
            if (num2Chars[j] > num1Chars[i]) {
                num1Chars[i] = num2Chars[j];
                j++;
            }
        }

        return Integer.parseInt(new String(num1Chars));
    }

    //9
    private static final Map<String, Integer> CITY_TIME_ZONES = new HashMap<>();
    
    static {
        CITY_TIME_ZONES.put("Los Angeles", -8 * 60);  
        CITY_TIME_ZONES.put("New York", -5 * 60);      
        CITY_TIME_ZONES.put("Caracas", -4 * 60 + 30); 
        CITY_TIME_ZONES.put("Buenos Aires", -3 * 60);
        CITY_TIME_ZONES.put("London", 0);              
        CITY_TIME_ZONES.put("Rome", 1 * 60);          
        CITY_TIME_ZONES.put("Moscow", 3 * 60);        
        CITY_TIME_ZONES.put("Tehran", 3 * 60 + 30);    
        CITY_TIME_ZONES.put("New Delhi", 5 * 60 + 30); 
        CITY_TIME_ZONES.put("Beijing", 8 * 60);        
        CITY_TIME_ZONES.put("Canberra", 10 * 60);      
    }

    public static String timeDifference(String cityA, String timestampA, String cityB) {
        int offsetA = CITY_TIME_ZONES.get(cityA);
        int offsetB = CITY_TIME_ZONES.get(cityB);

        int timeDifference = offsetB - offsetA;

        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date dateA = null;
        try {
            dateA = inputFormat.parse(timestampA);
        } catch (ParseException e) {
            System.err.println("Ошибка парсинга даты: " + e.getMessage());
            return null;
        }

        if (dateA == null) {
            return null;
        }

        long timeInMillis = dateA.getTime();

        timeInMillis += timeDifference * 60 * 1000;

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-M-d HH:mm");
        outputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        return outputFormat.format(new Date(timeInMillis));
    }

    //10
    public static boolean isNew(int number) {
        int currentDigit = 0;
        int digit = 9;
        while(number > 0) {
            currentDigit = number%10;
            number /=10;
            if (currentDigit == 0 || currentDigit <= digit) {
                if (currentDigit != 0) {
                    digit = currentDigit;
                }
            } else{
                return false;
            }
        }
        return true;
    }
}

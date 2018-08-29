package vadooss1_homework.taskStrings;

public class Task3 {
    public static void main(String[] args) {
        String userEnter = "deleveled, evitative, cat, dog, deified";
        System.out.println("There are " + countPalindromes(userEnter) + " palindromes in the text");

    }

    static int countPalindromes(String userEnter) {
        boolean checkPalindrome;
        int count;
        int result = 0;
        for (int i = 0; i < userEnter.length(); i++) {
            checkPalindrome = false;
            count = 0;
            while (i < userEnter.length() && userEnter.charAt(i) != ',') {
                if (userEnter.charAt(i) != ' ') {
                    count++;
                    i++;
                } else {
                    i++;
                }
            }
            for (int j = 0; j < count / 2; j++) {
                if (userEnter.charAt(i - count + j) != userEnter.charAt(i - 1 - j)) {
                    checkPalindrome = false;
                    break;
                } else {
                    checkPalindrome = true;
                }

            }
            if (checkPalindrome) {
                result++;
            }
        }
        return result;
    }
}

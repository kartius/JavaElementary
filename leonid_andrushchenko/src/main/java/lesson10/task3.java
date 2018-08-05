package lesson10;

public class task3 {
    public static void main(String[] args) {
        String str = "deleveled, evitative, cat, dog, deified";
        String[] words = str.split(", ");

        int palindromes = 0;
        for (int i = 0; i < words.length; i++){
            if (isPalindrome(words[i]))
                palindromes++;
        }
        System.out.println(" There are " + palindromes + " palindromes in the text");

    }
    public static boolean isPalindrome(String str){
        int begin = 0;
        int end = str.length() - 1;

        while(begin < end){
            if (str.charAt(begin) != str.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }
}

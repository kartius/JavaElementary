package vadooss1_homework.taskStrings;

public class Task1 {
    public static void main(String[] args) {
        String str1 = "person@gmail.com";
        String result = str1.replace("@", "[ at ]");
        result = result.replace(".", "[ dot ]");

        System.out.println(result);
    }
}

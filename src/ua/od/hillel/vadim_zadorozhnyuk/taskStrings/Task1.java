package ua.od.hillel.vadim_zadorozhnyuk.taskStrings;

public class Task1 {
    public static void main(String[] args) {
        String str1 = "person@gmail.com";
        String result = "";

        for (char i : str1.toCharArray()) {
            if (i == '@') {
                result += "[ at ]";
            } else if (i == '.') {
                result += "[ dot ]";
            } else {
                result += i;
            }
        }

        System.out.println(result);
    }
}

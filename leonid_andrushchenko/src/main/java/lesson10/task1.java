package lesson10;

public class task1 {
    public static void main(String[] args) {
        String str = "andrushchenkoleonid@gmail.com";
        str = str.replaceAll("\\.", "[dot]").replaceAll("@", "[ at ]");
        System.out.println(str);
    }
}

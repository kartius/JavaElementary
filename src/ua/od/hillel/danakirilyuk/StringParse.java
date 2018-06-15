package ua.od.hillel.danakirilyuk;

public class StringParse {
    public static void main (String[] args) {

        String x = "1lesson1lesson1lesson";
        String z = x.replace("1", "2");
        String y = z.replace("n", "n ");
        System.out.println(y);
    }
}

package lesson7;

public class TestClass {
    public static void main(String[] args) {
        String str1="  123  ";
        String str2="  123  4";
        System.out.println(str1);
        System.out.println(str1.length());
        System.out.println(str1.trim());
        System.out.println(str1.trim().length());

        System.out.println("-------------------------");
        System.out.println(str2);
        System.out.println(str2.length());
        System.out.println(str2.trim());
        System.out.println(str2.trim().length());

        System.out.println("-------------------------");
        String str3=new String(" 123  ");
        System.out.println(str1.compareTo(str3)+" - я не понимаю, что это значит. что это за число?");

        System.out.println("-------------------------");
        char[] array=new char[8];
        str1.getChars(0,7,array,0);
        System.out.println(array);

        System.out.println("-------------------------");
        String str4=str1.replace(" ", "+");
        System.out.println(str4);

        System.out.println("-------------------------");
        System.out.println(str4.startsWith("+"));


    }
}

package lesson_7;

public class Runner {


    public static void main(String[] args) {


        TestObjectClass testObjectClass1 = new TestObjectClass(2, 3);


        TestObjectClass testObjectClass2 = new TestObjectClass(2, 3);


        System.out.println(testObjectClass1 == testObjectClass2);

        System.out.println(testObjectClass1.equals(testObjectClass2));


        String str1 = "123";
        String str2 = "123";

        String str3 = new String("123");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        System.out.println("------------------------------------");


        System.out.println(str3.intern() == str1);
        System.out.println(str3.equals(str1));




    }


}

package generics;

public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb;

        iOb=new Gen<Integer>(88);

        iOb.showType();

        int v=iOb.getob();
        System.out.println("Value "+v);

        Gen<String> strOb=new Gen<String>("Test");

        strOb.showType();

        String str=strOb.getob();
        System.out.println("Value "+str);
    }
}

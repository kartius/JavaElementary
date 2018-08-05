package generics;

public class NonGenDemo {
    public static void main(String[] args) {
        NonGen iOb=new NonGen(888);

        iOb.showType();

        int v=(Integer)iOb.getOb();
        System.out.println("Value "+v);

        NonGen  strOb=new NonGen("test");
        strOb.showType();

        String str=(String)strOb.getOb();
        System.out.println("Value "+str);

        iOb=strOb;
        v=(Integer)iOb.getOb();

    }
}

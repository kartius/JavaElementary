package generics;

public class SmpGen {
    public static void main(String[] args) {

        TwoGen<Integer, String> tgObj=new TwoGen<Integer, String>(8888, "TwoTest");
        tgObj.showTypes();


        int v=tgObj.ob1;
        System.out.println("Value "+v);
        String str=tgObj.ob2;
        System.out.println("Value "+str);
    }
}

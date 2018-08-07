package solo.generics;

public class GenIfDemo {
    public static void main(String[] args) {
        Integer inums[]={3,6,9,5,7};
        Character chs[]={'v','g','e','q','y'};

        MyClass<Integer> iob=new MyClass<Integer>(inums);
        MyClass<Character> cob=new MyClass<Character>(chs);

        System.out.println(iob.max()+" "+iob.min());
        System.out.println(cob.max()+" "+cob.min());

    }
}

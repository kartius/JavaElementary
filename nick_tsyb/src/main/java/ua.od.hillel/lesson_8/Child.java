package lesson_8;

public class Child extends Parent{

    @Override
    public void test() {
        super.test();
    }


    public void test2(){
        System.out.println("test2");
    }


    public static void main(String[] args) {
        Parent parent = new Child();



        Child child = (Child) parent;
        child.test();
    }
}

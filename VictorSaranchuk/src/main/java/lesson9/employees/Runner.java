package lesson9.employees;

public class Runner {

    public static void main(String[] args) {
        Builder builder=new Builder();
        System.out.println(builder.getClass().getName());
        Developer developer=new Developer();
        Tester tester=new Tester();


        Emloye[] emloyes=new Emloye[3];

        emloyes[0]=builder;
        emloyes[1]=developer;
        emloyes[2]=tester;

        for (Emloye employe : emloyes) {
            employe.work();
        }


        LazyEmployee lazyEmployee=new LazyEmployee() {
            };

        lazyEmployee.work();

        System.out.println("-------------");
        System.out.println(lazyEmployee.getClass().getName());



    }

}

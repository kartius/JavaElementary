package lesson_9.emploees;

public class Runner {


    public static void main(String[] args) {

        Builder builder = new Builder();


        System.out.println(builder.getClass().getName());



        Developer developer = new Developer();
        Tester tester = new Tester();


        Employe[] employes = new Employe[3];


        employes[0]=builder;
        employes[1]=developer;
        employes[2]=tester;


        for (Employe employe : employes) {

            employe.work();
        }



        LazyEmployee lazyEmployee = new LazyEmployee(){};

        lazyEmployee.work();


        System.out.println("--------------");

        System.out.println(lazyEmployee.getClass().getName());



    }



}

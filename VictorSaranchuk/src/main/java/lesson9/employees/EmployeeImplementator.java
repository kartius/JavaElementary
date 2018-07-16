package lesson9.employees;

public class EmployeeImplementator {

    public void implement(Emloye employe){

    }

    public static void main(String[] args) {
        EmployeeImplementator employeeImplementator=new EmployeeImplementator();
        employeeImplementator.implement(new Emloye() {
            @Override
            void work() {
                System.out.println("blabla");
            }
        });
    }


}

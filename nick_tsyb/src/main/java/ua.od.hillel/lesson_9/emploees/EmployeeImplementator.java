package lesson_9.emploees;

public class EmployeeImplementator {




    public void implement(Employe employe){


    }


    public static void main(String[] args) {



        EmployeeImplementator employeeImplementator  = new EmployeeImplementator();


        employeeImplementator.implement(new Employe() {
            @Override
            void work() {
                System.out.println("blalba");
            }
        });


    }



}

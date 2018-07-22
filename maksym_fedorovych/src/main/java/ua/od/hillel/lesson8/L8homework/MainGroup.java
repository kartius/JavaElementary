package main.java.ua.od.hillel.lesson8.L8homework;

public class MainGroup {

    public int aMax = 30;
    public Student[] student = new Student[aMax];/*max 30 Students in class*/
    private int RealAmount = 0;

    public boolean addStudent(Student std){ /*AddStudent to class*/
        if (RealAmount + 1 < aMax)
        {student[RealAmount] = std;
         RealAmount++;
         return true;
        }
            else {System.out.println("Класс заполнен!"); return false;}
    }

    public void delStudent(Student std){

        for (int i = 0; i <= RealAmount - 1; i++)
        {
            if (student[i].unicid == std.unicid) //нашли удаляемого студента
            {
                for (int n = i; n <= RealAmount - 1; n++ )
                {
                    student[n] = student[n+1];      //Сдвигаем студентов замещая удаляемого до предпоследнего. В него попадает последний.
                }
                student[RealAmount] = null; //Очищаем ссылку на последнего
                break; //Exit from cycle on i
            }
        }
    }
    public int getRealAmount(){/*Return Real amount Student in class*/
        return RealAmount;
    }
}

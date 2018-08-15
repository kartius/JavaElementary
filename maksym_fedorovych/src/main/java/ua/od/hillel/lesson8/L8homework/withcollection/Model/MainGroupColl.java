package main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model;

import java.util.ArrayList;
import java.util.List;

public class MainGroupColl {
private int unicid;

    public int aMax = 30;


//    public StudentColl[] student = new StudentColl[aMax];/*max 30 Students in class*/
    private List<StudentColl> students = new ArrayList<>();

    private int RealAmount = 0;

    public boolean addStudent(StudentColl std){ /*AddStudent to class*/
        //System.out.println(students.size());
        if (students.size() < aMax) {students.add(std); return true;}
        else {System.out.println("Класс заполнен!"); return false;}
    }




    public void delStudent(StudentColl std){
         for (int i = 0; i < students.size(); i++)
         {
             if(students.get(i).equals(std))
             {students.remove(i);}
         }
    }
    public int getRealAmount(){/*Return Real amount StudentColl in class*/
        return students.size();
    }

    public void setUnicid(int unicid) {
        this.unicid = unicid;
    }

    public int getUnicid() {
        return this.unicid;
    }


}

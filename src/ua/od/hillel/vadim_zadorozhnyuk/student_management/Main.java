package ua.od.hillel.vadim_zadorozhnyuk.student_management;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        GroupManager groupManager = new GroupManager();
        Gson json = new Gson();
        SpecialClass specialClass = new SpecialClass();

        System.out.println(studentService.getListSubjects());
        System.out.println(studentService.getLevelCass(DB_objects.fedya));
        groupManager.addStudentGroup(DB_objects.kolya, DB_objects.group1);
        groupManager.addStudentGroup(DB_objects.olya, DB_objects.group2);
        studentService.addSubject(DB_objects.kolya, DB_objects.java);

        System.out.println(groupManager.getGroups());



    }

}

package lesson8;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args)
    {
        Subject subject1 = new Subject("Computer science");
        Group group1 = new Group("C1", subject1);
        SchoolClass schoolClass1 = new SchoolClass(1, "1-A");
        Student student1 = new Student("Ivan Iavnov", schoolClass1);


        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);

        ArrayList<SchoolClass> schoolClasses = new ArrayList<>();
        schoolClasses.add(schoolClass1);

        GroupManager groupManager = new GroupManager();
        groupManager.addGroup(group1);

        StudentService studentService = new StudentService();
        studentService.addSubject(subject1);


    }
}

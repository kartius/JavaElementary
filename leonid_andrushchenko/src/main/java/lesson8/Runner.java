package lesson8;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args)
    {
        Subject subject1 = new MockSubject("Computer science");
        Group group1 = new MockGroup("C1", subject1);
        SchoolClass schoolClass1 = new MockSchoolClass(1, "1-A");
        Student student1 = new MockStudent("Ivan Iavnov", schoolClass1);

        GroupManager groupManager = new GroupManager();
        groupManager.addGroup(group1);

        StudentService studentService = new StudentService();
        studentService.addSubject(subject1);

    }
}

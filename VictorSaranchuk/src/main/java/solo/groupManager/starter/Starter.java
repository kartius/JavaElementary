package solo.groupManager.starter;
import solo.groupManager.model.*;
import solo.groupManager.persisting.*;
import solo.groupManager.persisting.impl.*;
import solo.groupManager.persisting.impl.file.GroupRepositoryFile;
import solo.groupManager.persisting.impl.file.StudentRepositoryFile;
import solo.groupManager.services.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Starter {

    public static void main(String[] args) {
        //create a school
        List<Subject> subjects=Arrays.asList(new Subject("Physics")
                            , new Subject("Philosophy")
                            , new Subject("Anatomy")
                            , new Subject("Sport")
                            , new Subject("Biology")
                            , new Subject("Math"));

        SchoolClass schoolClass=new SchoolClass();
        schoolClass.setLevel(1);
        schoolClass.setSubjects(subjects);

        //create a students
        Student student1=new Student();
        student1.setId(1);
        student1.setName("Larry");
        student1.setSchoolClass(schoolClass);
        student1.setGroups(new ArrayList<Group>());

        Student student2=new Student();
        student2.setId(2);
        student2.setName("Barry");
        student2.setSchoolClass(schoolClass);
        student2.setGroups(new ArrayList<Group>());

        Student student3=new Student();
        student3.setId(3);
        student3.setName("Terry");
        student3.setSchoolClass(schoolClass);
        student3.setGroups(new ArrayList<Group>());

        Student student4=new Student();
        student4.setId(4);
        student4.setName("Alice");
        student4.setSchoolClass(schoolClass);
        student4.setGroups(new ArrayList<Group>());

        Student student5=new Student();
        student5.setId(5);
        student5.setName("Cooper");
        student5.setSchoolClass(schoolClass);
        student5.setGroups(new ArrayList<Group>());

        Student student6=new Student();
        student6.setId(6);
        student6.setName("Donald");
        student6.setSchoolClass(schoolClass);
        student6.setGroups(new ArrayList<Group>());

        //create groups
        Group group1=new Group();
        group1.setId(1);
        group1.setSubject(new Subject("Painting"));
        group1.setStudents(new ArrayList<Student>());

        Group group2=new Group();
        group2.setId(2);
        group2.setSubject(new Subject("Flying"));
        group2.setStudents(new ArrayList<Student>());

        StudentRepository studentRepository=new StudentRepositoryInMemory();
        GroupRepository groupRepository=new GroupRepositoryInMemory();

//        if (System.getenv("ENV_TYPE") != null) {
//            System.out.println("environment is " + System.getenv("ENV_TYPE"));
//            if (System.getenv("ENV_TYPE").equals("dev")) {
//                studentRepository = new StudentRepositoryInMemory();
//                groupRepository = new GroupRepositoryInMemory();
//            } else if (System.getenv("ENV_TYPE").equals("qa")) {
//                studentRepository = new StudentRepositoryFile();
//                groupRepository = new GroupRepositoryFile();
//            } else if (System.getenv("ENV_TYPE").equals("prod")) {
//                //init db implementation
//            }
//        } else {
//            System.out.println("please set env type! Now using default implementation");
//            studentRepository = new StudentRepositoryInMemory();
//            groupRepository = new GroupRepositoryInMemory();
//        }

        StudentService studentService=new StudentService();
        studentService.setStudentRepository(studentRepository);

        studentService.add(student1);
        studentService.add(student2);
        studentService.add(student3);

        GroupManager groupManager=new GroupManager();
        groupManager.setStudentRepository(studentRepository);
        groupManager.setGroupRepository(groupRepository);


        groupManager.add(group1);
        groupManager.add(group2);

        groupManager.assignStudentToGroup(group1, student1);
        groupManager.assignStudentToGroup(group1, student2);
        groupManager.assignStudentToGroup(group1, student3);
        groupManager.assignStudentToGroup(group1, student4);
        groupManager.assignStudentToGroup(group1, student5);
        groupManager.assignStudentToGroup(group1, student6);


        groupManager.assignStudentToGroup(group2,student1);
        groupManager.assignStudentToGroup(group2,student3);

        //create SpecialClass
        SpecialClass specialClass=new SpecialClass();

        specialClass.add(student1);


        System.out.println(groupManager.getAmountOfAvailableGrous());





    }

}

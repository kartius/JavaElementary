package ua.od.hillel.groupManager.starter;

import ua.od.hillel.groupManager.model.Group;
import ua.od.hillel.groupManager.model.SchoolClass;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;
import ua.od.hillel.groupManager.persisting.GroupRepository;
import ua.od.hillel.groupManager.persisting.StudentRepository;
import ua.od.hillel.groupManager.persisting.impl.GroupRepositoryInMemory;
import ua.od.hillel.groupManager.persisting.impl.StudentRepositoryInMemory;
import ua.od.hillel.groupManager.services.GroupManager;
import ua.od.hillel.groupManager.services.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Starter {


    public static void main(String[] args) {

               //init school
        List<Subject> subjects = Arrays.asList(new Subject("History")
                , new Subject("Math")
                , new Subject("Geography")
                , new Subject("Phylosophy")
                , new Subject("IT")
                , new Subject("Languages"));

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setLevel(1);
        schoolClass.setSubjects(subjects);


        //init students
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Petr");
        student1.setSchoolClass(schoolClass);
        student1.setGroups(new ArrayList<Group>());

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Ivan");
        student2.setSchoolClass(schoolClass);
        student2.setGroups(new ArrayList<Group>());

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("Fedor");
        student3.setSchoolClass(schoolClass);
        student3.setGroups(new ArrayList<Group>());

        //init groups

        Group group1 = new Group();
        group1.setId(1);
        group1.setSubject(new Subject("History of Greece"));
        group1.setStudents(new ArrayList<Student>());

        Group group2 = new Group();
        group2.setId(2);
        group2.setSubject(new Subject("Quantum physics"));
        group2.setStudents(new ArrayList<Student>());

        StudentRepository studentRepository = new StudentRepositoryInMemory();
        GroupRepository groupRepository = new GroupRepositoryInMemory();


        StudentService studentService = new StudentService();
        studentService.setStudentRepository(studentRepository);

        studentService.add(student1);
        studentService.add(student2);
        studentService.add(student3);

        GroupManager groupManager = new GroupManager();
        groupManager.setStudentRepository(studentRepository);
        groupManager.setGroupRepository(groupRepository);

        groupManager.add(group1);
        groupManager.add(group2);

        groupManager.assignStudentToGroup(group1, student1);
        groupManager.assignStudentToGroup(group1, student2);
        groupManager.assignStudentToGroup(group1, student3);

        groupManager.assignStudentToGroup(group2, student2);
        groupManager.assignStudentToGroup(group2, student3);

        System.out.println(groupManager.getAmountOfAvailableGroups());




    }
}

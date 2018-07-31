package groupManager.starter;
import groupManager.model.*;
import groupManager.persisting.*;
import groupManager.persisting.impl.*;
import groupManager.services.*;

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
                            , new Subject("Biology"));

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

        //create groups
        Group group1=new Group();
        group1.setId(1);
        group1.setSubject(new Subject("Painting"));
        group1.setStudents(new ArrayList<Student>());

        Group group2=new Group();
        group1.setId(2);
        group1.setSubject(new Subject("Flying"));
        group1.setStudents(new ArrayList<Student>());

        StudentRepository studentRepository=new StudentRepositoryInMemory();
        GroupRepository groupRepository=new GroupRepositoryInMemory();

        StudentService studentService=new StudentService();
        studentService.setStudentRepository(studentRepository);

        studentService.add(student1);
        studentService.add(student2);
        studentService.add(student3);

        GroupManager groupManager=new GroupManager();
        groupManager.setGroupRepository(groupRepository);

        groupManager.add(group1);
        groupManager.add(group2);

        groupManager.assignStudentToGroup(group1,student1);
        groupManager.assignStudentToGroup(group1,student2);
        groupManager.assignStudentToGroup(group1,student3);

        groupManager.assignStudentToGroup(group2,student1);
        groupManager.assignStudentToGroup(group2,student3);

        System.out.println(groupManager.getAmountOfAvailableGrous());





    }

}

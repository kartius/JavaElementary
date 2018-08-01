package ua.od.hillel.vadim_zadorozhnyuk.student_management;

import com.google.gson.Gson;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.persisting.GroupRepository;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.persisting.GroupRepositoryInMemory;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.persisting.StudentRepository;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.persisting.StudentRepositoryInMemory;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.services.GroupManager;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.services.StudentService;

public class Main {
    public static void main(String[] args) throws Exception {

        StudentRepository studentRepository = new StudentRepositoryInMemory();
        GroupRepository groupRepository = new GroupRepositoryInMemory();

        StudentService studentService = new StudentService();
        studentService.setStudentRepository(studentRepository);
        GroupManager groupManager = new GroupManager();
        groupManager.setGroupRepository(groupRepository);
        Gson json = new Gson();

        SpecialClass specialClass = new SpecialClass();

        Subject java = new Subject("Java");
        Subject english = new Subject("English");
        Subject dataBase = new Subject("DataBases");

        Student vasya = new Student("Vasya",1);
        Student petya = new Student("Petya",2);
        Student fedya = new Student("Fedya",3);
        Student lena = new Student("Lena",4);
        Student yulia = new Student("Yulia",5);
        Student olya = new Student("Oliya",6);
        Student ura = new Student("Ura",7);
        Student kolya = new Student("Kolya",8);
        Student oleg = new Student("Oleg",9);
        Student fred = new Student("Fred",10);

        SchoolClass oneClass = new SchoolClass(1);
        oneClass.setSubject(java);
        oneClass.addStudent(vasya);
        oneClass.addStudent(petya);
        oneClass.addStudent(fedya);
        SchoolClass twoClass = new SchoolClass(2);
        twoClass.setSubject(java);
        twoClass.addStudent(lena);
        twoClass.addStudent(yulia);
        twoClass.addStudent(olya);
        SchoolClass threeClass = new SchoolClass(3);
        threeClass.setSubject(java);
        threeClass.addStudent(ura);
        threeClass.addStudent(kolya);
        threeClass.addStudent(oleg);
        threeClass.addStudent(fred);
        specialClass.addStudent(fred);

        Group group1 = new Group(english, 1);
        Group group2 = new Group(dataBase, 2);

        studentService.add(vasya);
        groupManager.add(group1);
        groupManager.add(group2);
        groupManager.assignStudentToGroup(group1,vasya);
        groupManager.assignStudentToGroup(group1,petya);
        groupManager.assignStudentToGroup(group1,fedya);

        System.out.println(groupManager.getAmountOfAvailableGroups());







    }

}

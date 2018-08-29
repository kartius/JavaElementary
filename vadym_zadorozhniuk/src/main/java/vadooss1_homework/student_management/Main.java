package vadooss1_homework.student_management;

import com.google.gson.Gson;
import vadooss1_homework.student_management.persisting.GroupRepository;
import vadooss1_homework.student_management.persisting.toFile.GroupRepositoryInFile;
import vadooss1_homework.student_management.persisting.toFile.StudentRepositoryInFile;
import vadooss1_homework.student_management.persisting.toMemory.GroupRepositoryInMemory;
import vadooss1_homework.student_management.persisting.StudentRepository;
import vadooss1_homework.student_management.persisting.toMemory.StudentRepositoryInMemory;
import vadooss1_homework.student_management.services.GroupManager;
import vadooss1_homework.student_management.services.StudentService;

public class Main {
    public static void main(String[] args) throws Exception {

        StudentRepository studentRepository = new StudentRepositoryInFile();
        GroupRepository groupRepository = new GroupRepositoryInFile();

        StudentService studentService = new StudentService();
        studentService.setStudentRepository(studentRepository);
        GroupManager groupManager = new GroupManager();
        groupManager.setGroupRepository(groupRepository);
        Gson json = new Gson();

        Subject java = new Subject("Java");
        Subject english = new Subject("English");
        Subject dataBase = new Subject("DataBases");
        Subject html = new Subject("HTML");

        SpecialClass specialClass = new SpecialClass(html);

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
        groupManager.assignStudentToGroup(group2,vasya);
        groupManager.assignStudentToGroup(group1,petya);
        groupManager.assignStudentToGroup(group1,fedya);


        System.out.println(groupManager.getAmountOfAvailableGroups());
        System.out.println(json.toJson(studentService.getAllSubjects(vasya)));







    }

}

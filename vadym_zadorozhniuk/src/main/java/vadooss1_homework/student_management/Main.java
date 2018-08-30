package vadooss1_homework.student_management;

import com.google.gson.Gson;
import vadooss1_homework.student_management.persisting.GroupRepository;
import vadooss1_homework.student_management.persisting.toDB.AddToDB;
import vadooss1_homework.student_management.persisting.toDB.GroupRepositoryInDB;
import vadooss1_homework.student_management.persisting.toDB.StudentRepositoryInDB;
import vadooss1_homework.student_management.persisting.toFile.GroupRepositoryInFile;
import vadooss1_homework.student_management.persisting.toFile.StudentRepositoryInFile;
import vadooss1_homework.student_management.persisting.toMemory.GroupRepositoryInMemory;
import vadooss1_homework.student_management.persisting.StudentRepository;
import vadooss1_homework.student_management.persisting.toMemory.StudentRepositoryInMemory;
import vadooss1_homework.student_management.services.GroupManager;
import vadooss1_homework.student_management.services.StudentService;

public class Main {
    public static void main(String[] args) throws Exception {



        StudentRepository studentRepository = new StudentRepositoryInDB();
        GroupRepository groupRepository = new GroupRepositoryInDB();

        StudentService studentService = new StudentService();
        studentService.setStudentRepository(studentRepository);
        GroupManager groupManager = new GroupManager();
        groupManager.setGroupRepository(groupRepository);
        Gson json = new Gson();

        Subject java = new Subject("Java");
        AddToDB.subjectAdd("Java");
        Subject english = new Subject("English");
        AddToDB.subjectAdd("English");
        Subject dataBase = new Subject("DataBases");
        AddToDB.subjectAdd("DataBases");
        Subject html = new Subject("HTML");
        AddToDB.subjectAdd("HTML");

        SpecialClass specialClass = new SpecialClass(html);
        AddToDB.specialClassAdd(2);

        Student vasya = new Student("Vasya",1);
        studentService.add(vasya);
        Student petya = new Student("Petya",2);
        studentService.add(petya);
        Student fedya = new Student("Fedya",3);
        studentService.add(fedya);
        Student lena = new Student("Lena",4);
        studentService.add(lena);
        Student yulia = new Student("Yulia",5);
        studentService.add(yulia);
        Student olya = new Student("Oliya",6);
        studentService.add(olya);
        Student ura = new Student("Ura",7);
        studentService.add(ura);
        Student kolya = new Student("Kolya",8);
        studentService.add(kolya);
        Student oleg = new Student("Oleg",9);
        studentService.add(oleg);
        Student fred = new Student("Fred",10);
        studentService.add(fred);

        SchoolClass oneClass = new SchoolClass(1);
        AddToDB.schoolClassAdd(1);
        oneClass.setSubject(java);
        oneClass.addStudent(vasya);
        AddToDB.studentIntoClass(vasya, 1);
        oneClass.addStudent(petya);
        AddToDB.studentIntoClass(petya, 1);
        oneClass.addStudent(fedya);
        AddToDB.studentIntoClass(fedya, 1);
        SchoolClass twoClass = new SchoolClass(2);
        AddToDB.schoolClassAdd(2);
        twoClass.setSubject(java);
        twoClass.addStudent(lena);
        AddToDB.studentIntoClass(lena, 2);
        twoClass.addStudent(yulia);
        AddToDB.studentIntoClass(yulia, 2);
        twoClass.addStudent(olya);
        AddToDB.studentIntoClass(olya, 2);
        SchoolClass threeClass = new SchoolClass(3);
        AddToDB.schoolClassAdd(3);
        threeClass.setSubject(java);
        threeClass.addStudent(ura);
        AddToDB.studentIntoClass(ura, 3);
        threeClass.addStudent(kolya);
        AddToDB.studentIntoClass(kolya, 3);
        threeClass.addStudent(oleg);
        AddToDB.studentIntoClass(oleg, 3);
        threeClass.addStudent(fred);
        AddToDB.studentIntoClass(fred, 3);

        specialClass.addStudent(fred);
        AddToDB.studentInSpecialclass(fred, 1);

        Group group1 = new Group(html, 1);
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
        System.out.println(json.toJson(groupManager.get(1)));
        System.out.println(json.toJson(groupManager.get(2)));







    }

}

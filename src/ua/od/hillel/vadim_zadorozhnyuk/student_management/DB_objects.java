package ua.od.hillel.vadim_zadorozhnyuk.student_management;


public class DB_objects {
    static Subject java = new Subject("Java", false);
    static Subject english = new Subject("English", true);
    static Subject dataBase = new Subject("DataBases", true);
    static Subject[] subjects = {java, english, dataBase};

    static Student vasya = new Student("Vasya",1);
    static Student petya = new Student("Petya",1);
    static Student fedya = new Student("Fedya",1);
    static Student lena = new Student("Lena",2);
    static Student yulia = new Student("Yulia",2);
    static Student olya = new Student("Oliya",2);
    static Student ura = new Student("Ura",3);
    static Student kolya = new Student("Kolya",3);
    static Student oleg = new Student("Oleg",3);

    static SchoolClass oneClass = new SchoolClass(1, new Subject[1], new Student[3]);
    static SchoolClass twoClass = new SchoolClass(2, new Subject[1], new Student[3]);
    static SchoolClass threeClass = new SchoolClass(3, new Subject[1], new Student[3]);

    static Group group1 = new Group(english);
    static Group group2 = new Group(dataBase);

    static Group[] groups = {group1, group2};



}

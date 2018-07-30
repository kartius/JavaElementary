package ua.od.hillel.vadim_zadorozhnyuk.student_management;


public class SchoolClass {
    protected int classLevel;
    protected Subject[] subjects;
    protected Student[] students;

    public SchoolClass(){};

    public SchoolClass(int classLevel, Subject[] subjects, Student[] students) {
        this.classLevel = classLevel;
        this.subjects = subjects;
        this.students = students;
    }
}

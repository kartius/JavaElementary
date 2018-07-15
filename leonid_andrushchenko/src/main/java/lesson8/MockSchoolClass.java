package lesson8;

import java.util.ArrayList;

public class MockSchoolClass implements SchoolClass {
    private String name;
    private int level;// Уровень данного класса
    private ArrayList<Student> students = new ArrayList<Student>();// Список студентов
    private ArrayList<Subject> subjects = new ArrayList<Subject>();// Список изучаемых предметов

    public MockSchoolClass(int level, String name){
        this.level = level;
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public ArrayList <Student> getStudents(){
        return students;
    }

    @Override
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public void deleteStudent(String student_name){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getName().equals(student_name)){
                students.remove(i);
                break;
            }
        }
    }

    @Override
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public void deleteSubject(String subject_name) {
        for (int i = 0; i < subjects.size(); i++){
            if (subjects.get(i).getName().equals(subject_name)){
                subjects.remove(i);
                break;
            }
        }
    }
}

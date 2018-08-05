package lesson8;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Subject> optional_subjects = new ArrayList<Subject>();// Список всех опциональных предметов студента
    private SchoolClass schoolClass;// Класс, в котором учится студент

    public Student(String name, SchoolClass schoolClass)
    {
        this.name = name;
        this.schoolClass = schoolClass;
    }


    public String getName(){
        return name;
    }


    public ArrayList<Subject> getOptional_subjects()// Получает списка предметов студента
    {
        return optional_subjects;
    }


    public SchoolClass getSchoolClass() {
        return schoolClass;
    }


    public void addSubject(Subject subject)// Добавляет новый предмет в список студента
    {
        optional_subjects.add(subject);
    }


    public void deleteSubject(String subject_name)// Находит предмет из списка студента по названию и удаляет его
    {
        for(int i = 0; i < optional_subjects.size(); i++){
            if(optional_subjects.get(i).getName().equals(subject_name)){
                optional_subjects.remove(i);
                return;
            }
        }
        System.out.println("Предмет не найден");
    }
}

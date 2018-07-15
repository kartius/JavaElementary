package lesson8;

import java.util.ArrayList;

public class MockStudent implements Student {
    private String name;
    private ArrayList<Subject> optional_subjects = new ArrayList<Subject>();// Список всех опциональных предметов студента
    private SchoolClass schoolClass;// Класс, в котором учится студент

    public MockStudent(String name, SchoolClass schoolClass)
    {
        this.name = name;
        this.schoolClass = schoolClass;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public ArrayList<Subject> getOptional_subjects()// Получает списка предметов студента
    {
        return optional_subjects;
    }

    @Override
    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    @Override
    public void addSubject(Subject subject)// Добавляет новый предмет в список студента
    {
        optional_subjects.add(subject);
    }

    @Override
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

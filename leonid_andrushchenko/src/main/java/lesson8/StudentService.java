package lesson8;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<Subject> optional_subjects = new ArrayList<Subject>();// Список доступных опциональных предметов

    public void addSubject(Subject subject)
    {
        optional_subjects.add(subject);
    }


    public void deleteSubject(String subject_name)//  Находит предмет из списка по его названию и удаляет его
    {
        for (int i = 0; i < optional_subjects.size(); i++){
            if (optional_subjects.get(i).getName().equals(subject_name)){
                optional_subjects.remove(i);
                return;
            }
        }
        System.out.println("Данного предмета не существует");
    }

    public ArrayList<Subject> getOptional_subjects() // Возвращает список всех текущих опциональных предметов
    {
        return optional_subjects;
    }

    public int getClassLevel(Student student) // Возвращает уровень класса данного студента
    {
        return student.getSchoolClass().getLevel();
    }



}

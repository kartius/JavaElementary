package lesson8;

import java.util.ArrayList;

public interface Student {
    String getName();
    ArrayList<Subject> getOptional_subjects();// Возвращает список опциональных предметов, которых посещает студент
    void addSubject(Subject subject);// Добавляет данный предмет к списку предметов студента
    void deleteSubject(String subject_name);// Удаляет предмет с данным названием из списка предметов данного студента
    SchoolClass getSchoolClass();// Возвращает класс студента
}

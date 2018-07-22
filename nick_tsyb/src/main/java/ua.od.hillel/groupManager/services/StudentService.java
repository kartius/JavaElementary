package ua.od.hillel.groupManager.services;

import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;

public class StudentService {

    public int getLevelClassOfStudent(Student student) {
        return student.getSchoolClass().getLevel();
    }

    public Subject[] getAllSubjects(Student student) {
        int possibleGroups = student.getGroups().size();

        Subject[] groupSubjects = new Subject[possibleGroups];
        for (int i = 0; i <student.getGroups().size() ; i++) {
            if (student.getGroups().get(i).isAvailable()) {
                groupSubjects[i] = student.getGroups().get(i).getSubject();
            }
        }
        return student.getSchoolClass().getSubjects();

    }

}

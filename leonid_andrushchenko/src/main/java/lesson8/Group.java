package lesson8;

import java.util.ArrayList;

public interface Group {
    String getName();
    ArrayList <Student> getStudents();
    void addStudent(Student student);
    void deleteStudent(String student_name);
    boolean getStatus();//Возвращает true если группа действительна, в пративном случае возвращает false
    Subject getSubject();// Возвращает опциональный предмет, который проходят в данной гуппе
}

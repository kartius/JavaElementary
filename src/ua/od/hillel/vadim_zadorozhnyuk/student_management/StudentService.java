package ua.od.hillel.vadim_zadorozhnyuk.student_management;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StudentService {
    public void addSubject(Student student, Subject subject){
        student.subjects.addLast(subject);
    }
    public void delSubject(Student student, Subject subject){
        student.subjects.remove(subject);
    }
    public String getListSubjects(){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        return json.toJson(DB_objects.subjects);
    }
    public int getLevelCass(Student student){
        return student.classLevel;
    }


}

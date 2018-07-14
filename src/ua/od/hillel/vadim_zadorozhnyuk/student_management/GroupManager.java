package ua.od.hillel.vadim_zadorozhnyuk.student_management;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GroupManager {
public String getGroups(){
    Gson json = new GsonBuilder().setPrettyPrinting().create();
    return json.toJson(DB_objects.groups);
}
public void addStudentGroup(Student student, Group group){
    group.addStudent(student);
    student.subjects.addLast(group.subject);
}
public void delStudentGroup(Student student, Group group){
    group.delStudent(student);
    student.subjects.remove(group.subject);
}
}

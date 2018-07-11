package lesson8;

import java.util.ArrayList;

public class MockGroup implements Group {
    private String name;
    private boolean isActual = false;// данная переменная показывает является ли группа действительной
    private ArrayList<Student> students = new ArrayList<Student>();// Список студентов, состоящих в данной группе
    private Subject subject; // предмет, который проходится в данной группе

    public MockGroup(String name, Subject subject){
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public ArrayList <Student> getStudents(){
        return students;
    }

    @Override
    public void addStudent(Student student){
        students.add(student);

        if(!isActual && students.size() >= 3){
            isActual = true;
        }

    }
    @Override
    public void deleteStudent(String student_name) // Находит студента из списка по имени и удаляет его
    {
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getName().equals(student_name)){
                students.remove(i);
                if(isActual && students.size() < 3){
                    isActual = false;
                }
                return;
            }
        }
        System.out.println("Студент не найден");
    }

    @Override
    public boolean getStatus() {
        return isActual;
    }

    @Override
    public Subject getSubject() {
        return subject;
    }


}

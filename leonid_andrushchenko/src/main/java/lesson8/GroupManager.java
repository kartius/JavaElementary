package lesson8;

import java.util.ArrayList;

public class GroupManager {
    private ArrayList<Group> groups = new ArrayList<Group>();// Список всех групп

    public void addGroup(Group group)// Добавление новой группы
    {
        groups.add(group);
    }

    public void deleteGroup(String group_name) //Нахождение группы по названию и удаление её из списка
    {
        for (int i = 0; i < groups.size(); i++){
            if (groups.get(i).getName().equals(group_name)){
                groups.remove(i);
                return;
            }
        }
        System.out.println("Данной группы не существует");
    }

    public ArrayList<Group> getGroups() //Возвращает список всех групп вместе со студентами
    {
        return groups;
    }

    public void add_student_to_group(Student student, String group_name)
    {
        for (int i = 0; i < groups.size(); i++)
        {
            if(groups.get(i).getName().equals(group_name)) {
                groups.get(i).addStudent(student);
                student.addSubject(groups.get(i).getSubject());// Добавляет предмет в список студента
            }
            return;
        }
        System.out.println("Группа не найдена");
    }

    public void delete_student_from_group(Student student, String group_name)// Находит группу по её названию и удаляет оттуда студента
    {
        for (int i = 0; i < groups.size(); i++)
        {
            if(groups.get(i).getName().equals(group_name)) {
                groups.get(i).deleteStudent(student.getName());
                student.deleteSubject(groups.get(i).getSubject().getName());// удаляет предмет из списка студента
            }
        }
        System.out.println("Группа не найдена");
    }
}

package lesson8HomeWork;

import java.util.ArrayList;

public class Students {

    GroupSub groupSub=new GroupSub();
    //Переменные
    private String name;
    private int lvl;
    ArrayList<String> groups=new ArrayList<String>();
    ArrayList<String> custom=new ArrayList<String>();

    //Конструктор для оформления студента
    public Students(String name, int lvl){
        this.name=name;
        this.lvl=lvl;
        }

    //Метод показывающий предметы закреплённые за студентом
        void showSubjects(){
            System.out.println("Optional subjects for "+name+" : "+getGroups());
            System.out.println("Custom subjects for "+name+" : "+getCustom()+"\n");
        }




    //Геттеры и Сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public ArrayList<String> getGroups() {
        return groups;

    }

    public void setGroups(String gg) {
        this.groups.add(gg);
        
    }

    public void removeGroups(String gg){
        this.groups.remove(gg);
    }



    public ArrayList<String> getCustom() {
        return custom;
    }

    public void setCustom(ArrayList<String> gg) {
        this.custom=gg;

    }

    public void removeCustom(String gg){
        this.custom.remove(gg);
    }
}

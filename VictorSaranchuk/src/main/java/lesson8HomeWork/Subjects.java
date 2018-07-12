package lesson8HomeWork;


import java.util.ArrayList;

public class Subjects{

    public Subjects(){}
    String namesubj;
    public Subjects(String namesubj){
        this.namesubj=namesubj;
    }

//Уровни предметов
ArrayList<String> subjects1lvl=new ArrayList<String>();
ArrayList<String> subjects2lvl=new ArrayList<String>();



//Метод который по уровню получает какие предметы должны быть
    public ArrayList<String> getSubjectslvl(int i) {
        if (i == 1) {
            return subjects1lvl;
        } else { return subjects2lvl;
        }}

}


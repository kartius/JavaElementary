package lesson8HomeWorkChapter2;

import java.util.ArrayList;

public class Students {
    String group;
    String student;

public Students(String student){
    this.student=student;
}

void addGrouptoStd(Group obj, Students obf){
    this.group=obj.group;
    obj.addStdtoGroup(obf.student);
}

void showStd(){
    System.out.println(student+group);
}

    }




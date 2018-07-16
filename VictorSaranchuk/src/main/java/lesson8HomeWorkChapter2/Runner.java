package lesson8HomeWorkChapter2;

public class Runner {

    public static void main(String[] args) {

        Students student1=new Students("Ivanov");

        Group group1=new Group("Math");

        student1.addGrouptoStd(group1,student1);

        student1.showStd();
        group1.showGr();

    }
}

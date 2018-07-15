package lesson8HomeWorkChapter2;

public class Group {
    String student;
    String group;

    public Group(String group){
        this.group=group;
    }

    void addStdtoGroup(String student){
        this.student=student;
    }

    void showGr(){
        System.out.println(group+student);
    }
}

package groupManager.model;
import java.util.List;
import java.util.ArrayList;



public class SpecialClass extends SchoolClass {
    private Subject specialSubject=new Subject("Theory of Quantum Fields");
    List<Student> students=new ArrayList<Student>();

    public void add(Student student){
        students.add(student);
    }

    public void remove(Student student){
        students.remove(student);
    }

public Subject getSubject(){
    return specialSubject;
}

}

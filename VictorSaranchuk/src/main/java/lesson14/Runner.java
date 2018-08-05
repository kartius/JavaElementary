package lesson14;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {

        Student student1=new Student();
        student1.setAge(1);

        Student student2=new Student();
        student2.setAge(1);


        Comparator<Student> comparator = new StudentAgeComparator();
        int compare=((StudentAgeComparator) comparator).compare(student1,student2);
        System.out.println(compare);


        Map<Integer,Student> studentMap=new HashMap<Integer, Student>();



    }
}

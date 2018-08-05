package lesson14;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}

package ua.od.hillel.lesson_14_comparator_hashmap;

import java.util.Comparator;

public class StudentStringComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

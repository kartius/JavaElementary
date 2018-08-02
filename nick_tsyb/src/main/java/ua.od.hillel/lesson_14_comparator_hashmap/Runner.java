package ua.od.hillel.lesson_14_comparator_hashmap;

import java.util.*;

public class Runner {

    public static void main(String[] args) {


        Student s1 = new Student();
        s1.setAge(22);
        s1.setName("aaa");


        Student s2 = new Student();
        s2.setAge(22);
        s2.setName("bbb");


        Comparator<Student> comparator= new StudentAgeComparator().thenComparing(new StudentStringComparator());
        int compare = comparator.compare(s1, s2);
        System.out.println(compare);



        List<Student> list = new ArrayList<>();
        list.sort(comparator);





        Map<Integer,Student> studentsMap = new HashMap<>();





        CustomKey customKey = new CustomKey();
        customKey.setId(1);

        HashMap<CustomKey,String> map = new HashMap<>();


        map.put(customKey,"qwerty");

        System.out.println(map.get(customKey));

        customKey.setId(2);

        System.out.println(map.get(customKey));

        for (CustomKey key : map.keySet()) {
            System.out.println(key.getId());
        }










    }
}

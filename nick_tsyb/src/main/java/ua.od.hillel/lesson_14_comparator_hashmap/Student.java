package ua.od.hillel.lesson_14_comparator_hashmap;

public class Student implements Comparable<Student>{


    private Integer age;

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return age.compareTo(o.age);
    }
}

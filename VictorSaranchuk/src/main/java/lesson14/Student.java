package lesson14;

public class Student implements Comparable<Student> {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public String getName(){
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int compareTo(Student o) {
        return age.compareTo(o.age);
    }
}

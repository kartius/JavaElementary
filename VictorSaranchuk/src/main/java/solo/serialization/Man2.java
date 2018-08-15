package solo.serialization;

import java.io.Serializable;

public class Man2 implements Serializable {
    private String name;
    private String last_name;
    private int age;
    public static final long serialVersionUID=1L;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return "Man{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


}

package vadooss1_homework.readWrite;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    @XmlElement
    private int id;
    @XmlElement
    private String lastname;
    @XmlElement
    private String firstname;
    @XmlElement
    private int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastname=\"" + lastname + '\"' +
                ", firstname=\"" + firstname + '\"' +
                ", age=" + age +
                '}';
    }
}

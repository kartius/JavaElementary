package vadooss1_homework.readWrite;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

    private int id;
    private String lastname;
    private String firstname;
    private int age;


    public int getId() {
        return id;
    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }
    @XmlElement
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }
    @XmlElement
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }
    @XmlElement
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

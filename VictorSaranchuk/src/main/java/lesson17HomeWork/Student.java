package lesson17HomeWork;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private int age;

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }
    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }
    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }
}

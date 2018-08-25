package lesson17.task2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Student implements Serializable{
    private int ID;
    private String Lastname;
    private String Firstname;
    private int Age;

    public int getID() {
        return ID;
    }

    @XmlAttribute
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastname() {
        return Lastname;
    }

    @XmlElement
    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    @XmlElement
    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public int getAge() {
        return Age;
    }

    @XmlElement
    public void setAge(int age) {
        Age = age;
    }
}

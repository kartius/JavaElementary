package ua.od.hillel.lesson_16.serialization;

import java.io.Serializable;

public class Address implements Serializable {


    private static final long serialVersionUID = 1L;
    private String street;
    private String country;
    private transient int i;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return new StringBuffer(" Street : ")
                .append(this.street)
                .append(" Country : ")
                .append(this.country).toString();
    }

}

package lesson16.serialization;

import java.io.Serializable;

public class Adress implements Serializable {

    private String street;
    private String country;
    private static final long serialVersionUID = 1l;
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

    @Override
    public String toString() {
        return new StringBuffer("Street: ")
                    .append(this.street)
                    .append(" Country: ")
                    .append(this.country).toString();
    }
}

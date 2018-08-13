package HashMapTask;

import java.util.Objects;

public class Guest {
    protected String surname;
    private String firstLetter;
    public Guest(String surname){
        this.surname = surname;
        firstLetter = surname.substring(0, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(surname, guest.surname);
    }

    @Override
    public int hashCode() {

        return firstLetter.hashCode();
    }
}

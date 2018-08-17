package HashCode;

public class Guest {

    private String name;

    public Guest (String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return name != null ? name.equals(guest.name) : guest.name == null;
    }

    @Override
    public int hashCode() {

        String c = name.substring(0, 1);

        return name != null ? c.hashCode() : 0;
    }



}

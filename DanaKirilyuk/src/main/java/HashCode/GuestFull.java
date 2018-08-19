package HashCode;

public class GuestFull {

    private String name;

    public GuestFull(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestFull guestFull = (GuestFull) o;
        return name != null ? name.equals(guestFull.name) : guestFull.name == null;
    }

    @Override
    public int hashCode() {
        String c = name;

        return name != null ? c.hashCode() : 0;
    }
}

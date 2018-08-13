package HashMapTask;

public class ModifiedGuest extends Guest {
    public ModifiedGuest(String surname) {
        super(surname);
    }

    @Override
    public int hashCode() {
        return super.surname.hashCode();
    }
}

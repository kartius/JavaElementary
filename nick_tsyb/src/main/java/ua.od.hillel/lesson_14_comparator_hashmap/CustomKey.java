package ua.od.hillel.lesson_14_comparator_hashmap;



public class CustomKey {



    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomKey customKey = (CustomKey) o;

        return id == customKey.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

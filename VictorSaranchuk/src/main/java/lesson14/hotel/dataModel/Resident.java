package lesson14.hotel.dataModel;

import java.util.Objects;

public class Resident {

    private String name;
    private String room;
    private char bucket;


    public String toString(){
return " name "+name+" live in room "+room;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setBucket(char bucket) {
        this.bucket = bucket;
    }

    public char getBucket() {
        return bucket;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return name == resident.name;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}

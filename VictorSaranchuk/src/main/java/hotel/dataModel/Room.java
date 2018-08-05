package hotel.dataModel;

import java.util.HashMap;

public class Room {
    private String roomNumber;
    private Resident resident;

    public boolean isEmpty(){
    if(resident!=null){
        return false;
    }else {
        return true;
    }
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public void settleResidentToRoom(Resident resident){
        if(isEmpty()!=true){
            System.out.println("Sorry, room is not Empty,\n"+resident.getName()+
            " can't be settled at room "+roomNumber);
        }else{
            this.resident=resident;
            System.out.println(resident.getName()+" is settled to room "+roomNumber);
        }
    }




}

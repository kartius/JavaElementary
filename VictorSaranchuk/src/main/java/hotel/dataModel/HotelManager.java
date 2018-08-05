package hotel.dataModel;

import java.util.HashMap;

public class HotelManager {

    //Settle Resident with checkin of empty room, and input to bucket with checkin' of emptyness
    public void settleResidentToRoom(Resident resident, Room room){
        if(room.isEmpty()!=true){
            System.out.println("Sorry, room is not Empty,\n"+resident.getName()+
                    " can't be settled to room "+room.getRoomNumber());
        }else{
            room.setResident(resident);
            resident.setRoom(room.getRoomNumber());
            resident.setBucket(resident.getName().charAt(0));
            System.out.println(resident.getName()+" settle to room "+room.getRoomNumber());
            mapOfResidents.put(resident,resident.toString());

            if(map.get(resident.getBucket())==null){
                map.put(resident.getBucket(), resident.toString());
            }else{
                map.put(resident.getBucket(), map.get(resident.getBucket())+" and\n"
                        +resident.toString());
            }

        }
    }


    HashMap<Resident ,String> mapOfResidents=new HashMap<>();
    HashMap<Character, String> map=new HashMap<Character, String>();



    public boolean isSettled(Resident resident){
        if(resident.getRoom()!=null){
        return true;
        }else{
            return false;
        }
    }

    public void show(Resident resident){
        System.out.println(mapOfResidents.get(resident));
    }

    public void  show2(char bucket){
        System.out.println("in a "+bucket+" bucket "+map.get(bucket));
    }

}

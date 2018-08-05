package hotel.starter;
import hotel.dataModel.*;


import java.util.*;


public class Starter {

    public static void main(String[] args) {

        //Create Rooms
        Room room1=new Room();
        room1.setRoomNumber("1");
        Room room2=new Room();
        room2.setRoomNumber("2");
        Room room3=new Room();
        room3.setRoomNumber("President's Lux");
        Room room4=new Room();
        room4.setRoomNumber("Best room");

        //Create Residents
        Resident resident1=new Resident();
        resident1.setName("John");
        Resident resident2=new Resident();
        resident2.setName("James");
        Resident resident3=new Resident();
        resident3.setName("Bill");
        Resident resident4=new Resident();
        resident4.setName("Bob");


        //Settle theResidents
        HotelManager hotelManager=new HotelManager();

        hotelManager.settleResidentToRoom(resident1,room1);
        hotelManager.settleResidentToRoom(resident2,room2);
        hotelManager.settleResidentToRoom(resident3,room3);
        hotelManager.settleResidentToRoom(resident4,room4);


        //Show resident's info from HashMap
        System.out.println("------------------------------");
        hotelManager.show(resident1);
        hotelManager.show(resident2);
        hotelManager.show(resident3);
        hotelManager.show(resident4);

        //Show who in a bucket
        System.out.println("------------------------------");

        hotelManager.show2('B');

        hotelManager.show2('J');
    }

}

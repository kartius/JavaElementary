package lesson_10;

public enum UserTypeEnum {


    ADMIN(1), MANAGER(2), CUSTOMER(3);


    private int id;

    UserTypeEnum(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }
}

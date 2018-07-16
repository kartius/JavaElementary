package lesson_10;

public class User {


    public void action(int userType) {


        if (userType == UserTypeEnum.ADMIN.getId()) {
            //TODO
        } else if (userType == UserType.CUSTOMER) {
            //TODO
        }

    }


    public void action(UserTypeEnum userType) {

        if (userType.equals(UserTypeEnum.ADMIN)) {
            //TODO
        }


    }


}

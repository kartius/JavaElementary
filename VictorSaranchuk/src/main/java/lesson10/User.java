package lesson10;

public class User {

    public void action(int userType){
        if(userType==UserTypeEnum.ADMIN.getId()) {

        }else if(userType==UserTypeEnum.CUSTOMER.getId()){

        }else if(userType==UserTypeEnum.MANAGER.getId()){

        }
    }
    public void  action(UserTypeEnum userType){
        if(userType.equals(UserTypeEnum.ADMIN)){

        }else if(userType.equals(UserTypeEnum.CUSTOMER)){

        }        else if(userType.equals(UserTypeEnum.MANAGER)){


        }

    }
}

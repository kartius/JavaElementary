package lesson10;

public class User {

    public void action(int userType){
        if(userType==UserTypeEnum.ADMIN.getId()) {
            //TODO
        }else if(userType==UserTypeEnum.CUSTOMER.getId()){
            //TODO
        }else if(userType==UserTypeEnum.MANAGER.getId()){
            //TODO
        }
    }
    public void  action(UserTypeEnum userType){
        if(userType.equals(UserTypeEnum.ADMIN)){
            //TODO
        }else if(userType.equals(UserTypeEnum.CUSTOMER)){
            //TODO
        }        else if(userType.equals(UserTypeEnum.MANAGER)){
            //TODO

        }

    }
}

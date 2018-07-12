package lesson8HomeWork;

import java.util.ArrayList;

public class GroupSub {
    String namegr;
    ArrayList<String> namest=new ArrayList<String>();


    public GroupSub(String namegr){
        this.namegr=namegr;
    }


    public String getNamegr() {
        return namegr;
    }

    public void setNamegr(String namegr) {
        this.namegr = namegr;
    }

    public ArrayList<String> getNamest() {
        return namest;
    }


    public void setNamest(String student) {

        namest.add(student);
    }


    public void removeNamest(String gg) {
        this.namest.remove(gg);
    }

public GroupSub(Students obj){
        String name=obj.getName();
}

public void showGroup(){
    System.out.println("For group "+namegr+" "+namest);

}


}

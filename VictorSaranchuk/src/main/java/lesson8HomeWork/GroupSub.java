package lesson8HomeWork;

import java.util.ArrayList;

public class GroupSub {
    String namegr;
    ArrayList<String> namest=new ArrayList<String>();

    public GroupSub(){}

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

    public void setNamest(String gg) {
        this.namest.add(gg);
    }
    public void removeNamest(String gg) {
        this.namest.remove(gg);
    }
}

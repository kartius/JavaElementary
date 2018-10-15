package vadooss1_homework.atm.model;


import java.util.Date;

public class Transactions {
    private int id;
    private Date date;
    private boolean successTrans;


    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getSuccessTrans() {
        return successTrans;
    }
    public void setSuccessTrans(boolean successTrans) {
        this.successTrans = successTrans;
    }
}

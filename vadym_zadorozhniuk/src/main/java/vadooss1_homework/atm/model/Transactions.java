package vadooss1_homework.atm.model;


import java.sql.Timestamp;

public class Transactions {
    private int id;
    private Timestamp date;
    private boolean successTrans;
    private int userId;
    private int serviceId;


    public int getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean getSuccessTrans() {
        return successTrans;
    }
    public void setSuccessTrans(boolean successTrans) {
        this.successTrans = successTrans;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}

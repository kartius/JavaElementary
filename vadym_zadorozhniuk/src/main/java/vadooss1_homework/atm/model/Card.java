package vadooss1_homework.atm.model;

import java.sql.Date;

public class Card {
    private long id;
    private int pin;
    private String type;
    private boolean hasChip;
    private Date dateTerm;
    private String lockReason;
    private int enterPin;

    public long getId() {
        return id;
    }

    public int getPin() {
        return pin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getHasChip() {
        return hasChip;
    }

    public void setHasChip(boolean hasChip) {
        this.hasChip = hasChip;
    }

    public Date getDateTerm() {
        return dateTerm;
    }

    public void setDateTerm(Date dateTerm) {
        this.dateTerm = dateTerm;
    }

    public String getLockReason() {
        return lockReason;
    }

    public void setLockReason(String lockReason) {
        this.lockReason = lockReason;
    }

    public int getEnterPin() {
        return enterPin;
    }

    public void setEnterPin(int enterPin) {
        this.enterPin = enterPin;
    }
}

package vadooss1_homework.atm.model;

import java.util.Date;

public class Card {
    private int id;
    private short pin;
    private String type;
    private boolean hasChip;
    private Date dateTerm;
    private String lockReason;

    public int getId() {
        return id;
    }

    public short getPin() {
        return pin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPin(short pin) {
        this.pin = pin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasChip() {
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
}

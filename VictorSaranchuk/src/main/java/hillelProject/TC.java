package hillelProject;

public enum TC {AutoLux(1), Delivery(2), GunSel(3), InTime(4),
    New_Post(5), Night_Express(6), SAT(7);

private int tcId;

TC(int tcId){
    this.tcId=tcId;
}

public int getTCId(){
    return tcId;
}

}

package generics;

public class WildCardDemo {
    public static void main(String[] args) {
        Integer inums[]={1,2,3,4,5,6};
        Stats<Integer> iOb=new Stats<Integer>(inums);
        double v=iOb.average();
        System.out.println("AVG= "+v);

        Double dnums[]={1.1,2.2,3.3,4.4,5.5,6.6};
        Stats<Double> dOb=new Stats<Double>(dnums);
        double w=dOb.average();
        System.out.println("AVG= "+w);

        Float fnums[]={1.0F,2.0F,3.0F,4.0F,5.0F,6.0F};
        Stats<Float> fOb=new Stats<Float>(fnums);
        double x=fOb.average();
        System.out.println("AVG= "+x);

        System.out.println("iob and dob");
        if(iOb.sameAvg(dOb)) System.out.println("Equals");
        else System.out.println("not Equals");

        System.out.println("iob and fob");
        if(iOb.sameAvg(fOb)) System.out.println("Equals");
        else System.out.println("not Equals");


    }
}

package solo.generics;

public class BoundsDemo {
    public static void main(String[] args) {
        Integer inums[]={1,2,3,4,5,6};
        Stats<Integer> iOb=new Stats<Integer>(inums);
        double v=iOb.average();
        System.out.println("AVG "+v);

        Double dnums[]={1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        Stats<Double> dOb=new Stats<Double>(dnums);
        double w=dOb.average();
        System.out.println("AVG "+w);



    }
}

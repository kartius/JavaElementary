package JavaElementary.src.ua.od.hillel.anton_golyak;

public class EX {
    public void exchange(double summ, int var){
        switch(var){
            case 1:
                System.out.println((String.format("%.2f", (summ/26))+" USD" ));
                break;
            case 2:
                System.out.println((String.format("%.2f", (summ*26))+" UAH"));
                break;
            case 3:
                System.out.println((String.format("%.2f", (summ/31))+" EUR"));
                break;
            case 4:
                System.out.println((String.format("%.2f", (summ*31))+" UAH"));
                break;
        }
    }
}

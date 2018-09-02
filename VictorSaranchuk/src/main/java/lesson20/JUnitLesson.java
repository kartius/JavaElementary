package lesson20;

public class JUnitLesson {


    public static int funcSum(int n){
        String s=String.valueOf(n);
        char[] arrayC=s.toCharArray();
        int sum=0;
        for (char c:arrayC) {
            sum=sum+Character.getNumericValue(c);
        }
        return sum;
    }


    public static int funcFact(int n){
        int fact=1;
        for (int i=1; i<n;i++){
            fact*=(i+1);
        }
        return fact;
    }

    public static int squareCalc(int side, String formula){
        int perimeter=0;
        int square=0;

        if(formula.equalsIgnoreCase("perimeter")){
            perimeter=side*4;
            return perimeter;
        }

        else if(formula.equalsIgnoreCase("square")){
            square=side*side;
            return square;
        }

        else{
            return 0;
        }
    }

}

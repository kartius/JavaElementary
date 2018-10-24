package vadooss1_homework.for_testing;

public class TestingMethods {
    public int sumDigit(int number){
        int sum = 0;
        while(number>0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }

    public int factorial(int digit){
        int f = 1;
        for (int i = 1; i < digit; i++) {
            f*=(i+1);
        }
        return f;
    }

    public int squareCalculation(int side, String formula){
        int result=0;
        switch (formula){
            case "perimeter":result = side*4;break;
            case "square":result = side*side;break;
            default:break;
        }
        return result;
    }


}

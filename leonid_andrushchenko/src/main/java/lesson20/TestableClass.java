package lesson20;

public class TestableClass {
    public int sumOfDigits(int number) {
        if(number < 0){
            System.out.println("Вы ввели отрицательное число");
            return -1;
        }

        int result = 0;

        while(number > 0){
            result += (number % 10);
            number /= 10;
        }

        return result;
    }

    public long factorial(int number){
        if(number < 0){
            System.out.println("Вы ввели отрицательное число");
            return -1;
        }
        int result = 1;
        for(int i = 2; i <= number; i++){
            result *= i;
        }
        return result;
    }

    public int squareCalculation(int side, String formula){
        if(side < 0){
            System.out.println("Вы ввели отрицательное число");
            return -1;
        }

        if(formula.equals("square")){
            return side*side;
        }
        else if(formula.equals("perimeter")){
            return side*4;
        }
        else{
            return 0;
        }
    }
}

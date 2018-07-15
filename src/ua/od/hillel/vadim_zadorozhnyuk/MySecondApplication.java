package ua.od.hillel.vadim_zadorozhnyuk;

public class MySecondApplication {
    public static void main(String[] args) {
        //task1
        int myWeight = 80;
        double moonIndex = 0.17;
        System.out.println("My weight on moon is " + myWeight*moonIndex + " kg");

        //task2
        String n = "1lesson1lesson1lesson";
        n=n.replace("1", "2");
        StringBuffer result = new StringBuffer(n);
        int k=1;
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i)=='n'){
                result.insert(i+k, " ");
               k++;
            }

        }
        System.out.println(result);

        //task 3
        int from = 1, to = 5;
        int digit = (int)(Math.random()*(to-from)+from);

        System.out.println(digit);

        //task Factorial
        int number = 5;
        System.out.println("factorial " + number + " = " + factorial(number));

        //task Fibonacci
        int rowlength = 10;
        int first = 0;
        int second = 1;
        String fibo = first + ", " + second;
        int sum;

        for (int i = 2; i < rowlength; i++) {
            sum = first + second;
            first = second;
            second = sum;
            fibo+=", "+sum;

        }
        System.out.println(fibo);


    }
    static int factorial(int digit){
        int result;
        if (digit==1){
            return digit;
        }else{
            result = factorial(digit-1)*digit;
            return result;
        }

    }

}

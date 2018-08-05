package lesson11HomeWork;

public class Mass {







   static void makeMass(int length){
        int[] array=new int[length];
        System.out.println("Массив от 1 до "+length+": ");
        for (int i=0; i<length; i++){
            array[i]=i+1;
            System.out.print(array[i]+" ");}

        System.out.println("\n=============================");
        }

    static void reverseMass(int length){
        System.out.println("Инверсия массива от 1 до "+length+":");
        int[] array=new int[length];
        for (int i=0; i<length; i++){
            array[i]=i+1;}

        int[] sort=new int[length];
        for(int j=(length-1);j>=0;j--){
            sort[(length-1-j)]=array[j];
            System.out.print(sort[length-1-j]+" ");
        }
        System.out.println("\n=============================");
    }

    static void divThree(int length){
        int[] array=new int[length];
        for (int i=0; i<length; i++){
            array[i]=i+1;}
        System.out.println("Элементы мыссива, которые делятся на 3 без остатка");
        for (int i:array
                ) {
            if(i%3==0){
                System.out.print(i+" ");
            }
        }  System.out.println("\n=============================");

    }


    static void divTwo(int length){
        int[] array=new int[length];
        for (int i=0; i<length; i++){
            array[i]=i+1;}

        System.out.println("Чётные элемены мыссива");
        for (int i:array
                ) {
            if(i%2==0){
                System.out.print(i+" ");
            }
        }

        System.out.println("\n=============================");
    }


    static int sumElements(int length){
        int[] array=new int[length];
        for (int i=0; i<length; i++){
            array[i]=i+1;}

        int count=0;
        for (int i:array
                ) {
            count+=i;
        }
        return count;
    }

    static double avg(int length, int count){

       int[] array=new int[length];
        for (int i=0; i<length; i++){
            array[i]=i+1;}

        double avg=(double)count/length;
        return avg;
    }

    static void minMax(int length){

        System.out.println("Сума минимального и максимального элементов массива:");
        int[] array=new int[length];
        for (int i=0; i<length; i++){
            array[i]=i+1;}

        int min=array[0];
        int max=array[0];
        for(int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];

            if (array[i] < min)
                min = array[i];
        }
        System.out.println(min+max);
        System.out.println("\n=============================");

    }

    static void multnechet(int length){
        int[] array=new int[length];
        for (int i=0; i<length; i++){
            array[i]=i+1;}
        System.out.println("Произведение нечётных элементов массива:");
        long nechet=1;
        for (int i:array
                ) {
            if(i%2!=0){nechet*=i;}
        }
        System.out.println(nechet);
        System.out.println("\n=============================");
    }

    static void searchNumber(int length, int number){
        int[] array=new int[length];
        for (int i=0; i<length; i++){
            array[i]=i+1;}
        System.out.println("Введите число, индекс которого необходимо определить:");
        int index;
        for (int i=0; i<array.length; i++){
            if(number==array[i]){

                System.out.println("Индекс числа "+array[i]+": "+i);
            }
        }
        System.out.println("\n=============================");
    }
}

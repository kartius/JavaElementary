package ua.od.hillel.maksym_fedorovych;

public class l3Fibonacci {
    public static void main(String[] args) {
       /*Created by Maks_F 17.06.2018
         LessonHomeWork Fibonnachi
        */
      int PreviousInt = 0; //StartVlue
      int NextInt = 1;
      int PreviousInt1 = 0; //StartVlue
      int NextInt1 = 0;
      String FibonNumber = "Fibonachi Numbers: ";

      for  (int iCount = 0; iCount< 100; iCount++)
      {

         if (PreviousInt == 0 &&  NextInt == 1)
         {
             FibonNumber = FibonNumber + PreviousInt + ", " + NextInt;
             PreviousInt1 = NextInt;
             NextInt1 = PreviousInt1 + NextInt;
             PreviousInt = 1;
             NextInt = 1;
         }
         else
         {
             FibonNumber = FibonNumber + ", " + NextInt1 ;
             PreviousInt = PreviousInt1;
             NextInt = NextInt1;
             PreviousInt1 = NextInt;
             NextInt1 = PreviousInt + NextInt;
         }


          System.out.println(FibonNumber);

      }



    }
}

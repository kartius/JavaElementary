package ua.od.hillel.maksym_fedorovych;



public class ThirdTask {
   public static void main(String[] args) {
       /*Выравниваем наш интервал так чтоб минимальное значение было 0 и правилом пропорции считаем что максимум
          нашего интервала это 100%. Принимаем первые три разряда после "." рандома выпавшим процентом для пропорции.
          Если выпало 100 то максимум нашего выровненного  интервала, если более ста то берем два разряда.
          По правилу пропорции вычисляем целое значение и округляем, так чтоб алгоритм работал на малых итервалах.
          Вычисленное значение сдвигаем к нашему первичному интервалу.
        */
       double drandom; //случайное значение не спроецированное на интервал
       int minValue = -1000; //Нижний предел
       int maxValue = 1; //Верхний предел
       int toZero = 0; //смещение к 0
       int res; //результат

        toZero = minValue*-1;
        drandom = Math.random();


       int percentValue;
       if ((int)(drandom*1000) >100 ||(int)(drandom*1000) < 100 )
         { percentValue = (int)(drandom*100); }
         else
        { percentValue = (int)(drandom*1000); }



          res = (int)((Math.round(((maxValue + toZero)*percentValue/100.00))) - toZero);


          System.out.println("Случайное значение не спроецированное на интервал: " + drandom);
          System.out.println("Случайный процент: " + percentValue);
          System.out.println("Случайное значение: " + res);




   }
}

package main.java.CustomListCollection;

import javax.swing.text.Position;
import java.util.Iterator;

public class CustomArrayList implements CustomList{
    private static int random(int minValue, int maxValue)
    {


        maxValue -= minValue;
        return (int) (Math.random() * ++maxValue) + minValue;

        //double drandom; //случайное значение не спроецированное на интервал
      //  int toZero = 0; //смещение к 0
      //  int res; //результат

        //toZero = minValue*-1;
       // drandom = Math.random();


        //int percentValue;
        //if ((int)(drandom*1000) >100 ||(int)(drandom*1000) < 100 )
        //{ percentValue = (int)(drandom*100); }
//        else
  //      { percentValue = (int)(drandom*1000); }



    //    res = (int)((Math.round(((maxValue + toZero)*percentValue/100.00))) - toZero);


        //System.out.println("Случайное значение не спроецированное на интервал: " + drandom);
        //System.out.println("Случайный процент: " + percentValue);
        //System.out.println("Случайное значение: " + res);
      //  return res;

    }
    private String[] inArray;
    private int currIndex = -1;

    public CustomArrayList() {
        inArray = new String[0];
        System.out.println(inArray.length);
    }

    @Override
    public int size() {
        return inArray.length;
    }

    @Override
    public boolean isEmpty() {
        return (inArray.length == 0);
    }

    @Override
    public boolean contains(String element) {
        boolean flag = false;

        for (int i = 0; i < inArray.length; i++)
        {
            if (inArray[i] == element)
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void add(String element) {
        int aLength = inArray.length;

        if (aLength != 0)
        {
            String[] aArray = new String[inArray.length];
            for (int i = 0; i < inArray.length; i++) {aArray[i] = inArray[i];}
            inArray = new String[aLength + 1];
            for (int i = 0; i < aLength; i++) {inArray[i] = aArray[i];}
            inArray[aLength] = element;

        }
        else {
            inArray = new String[1];
            inArray[0] = element;
        }



    }

    @Override
    public void add(int index, String element) {
      int aLength = inArray.length;
          if (index > aLength - 1) {   /*Случай кода индекс превышает*/

              String[] aArray = new String[inArray.length];

              for (int i = 0; i < inArray.length; i++) {
                  aArray[i] = inArray[i];
              }
              inArray = new String[index + 1];
              for (int i = 0; i < aLength; i++) {
                  inArray[i] = aArray[i];
              }
              inArray[index] = element;
          } else /*Индекс меньше либо равен размерности старого листа*/
              {
                  String[] aArray = new String[inArray.length];
                  for (int i = 0; i < inArray.length; i++) {
                      aArray[i] = inArray[i];
                  }

                  inArray = new String[aLength + 1];
                  for (int i = 0; i < inArray.length ; i++)
                  {
                      if (i < index)
                      {inArray[i] = aArray[i];}
                      if (i == index) {inArray[i] = element;}
                      if (i > index) {inArray[i] = aArray[i-1];}
                  }

              }


    }

    @Override
    public boolean remove(String element) {
        int aLength = inArray.length;
        int j = -1;
        if (!contains(element)) {return false;}
        else
        {   /*Перенесли все всторону*/
            String[] aArray = new String[inArray.length];

            for (int i = 0; i < inArray.length; i++) {
                aArray[i] = inArray[i];
                if ((j == -1)&&(inArray[i] == element)) {j = i;}
            }

            inArray = new String[aLength - 1];
            for (int i = 0; i < aArray.length; i++) {
                if (i < j)  {inArray[i] = aArray[i];}
                if (i > j) {inArray[i-1] = aArray[i];}
            }
          return true;
        }
    }

    @Override
    public String remove(int index) {
        int aLength = inArray.length;
        if ((isEmpty())||(index >= aLength)) { return null;}
        else
        {
            String removeStr = inArray[index];

            String[] aArray = new String[inArray.length];

            for (int i = 0; i < inArray.length; i++) {
                aArray[i] = inArray[i];
             }

            inArray = new String[aLength - 1];
            for (int i = 0; i < aArray.length; i++) {
                if (i < index)  {inArray[i] = aArray[i];}
                if (i > index) {inArray[i-1] = aArray[i];}
            }

            return removeStr;
        }
    }

    @Override
    public void clear() {
        inArray = new String[0];
    }

    @Override
    public String get(int index) {
        return inArray[index];
    }

    @Override
    public void set(int index, String element) {
      if (index < inArray.length) {inArray[index] = element;}
      else {add(index, element);}
    }

    @Override
    public int indexOf(String element) {
        int j = -1;
        if (!contains(element)) {return j;}
        else
        {
            for (int i = 0; i < inArray.length; i++)
            {
                if (inArray[i] == element)
                {
                    j = i;

                    break;

                }
            }
            return j;
        }
    }

    @Override
    public Iterator backwardIterator() {
        return new BackwardIterator();
    }

    private class BackwardIterator implements Iterator {

        private int position = -1;
        BackwardIterator() {
          position = inArray.length - 1;
        }
        @Override
        public boolean hasNext() {
            return (position > 0);
        }

        @Override
        public Object next() { /*Не вижу смысла
                                 заморачиваться на єкзепшн т.к.
                                 либо нормальній прог сверху проверит hasMext
                                 либо получит превышение индекса*/
            return inArray[position--];
        }
    }

    @Override
    public Iterator randomIterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator {


        int position = -1;
        int valueposition = -1;
        int maxRandomInterval = 0;
        int minRandomInterval = 0;
        int[] inArrayRandom;

        private void SetMinUseIndex()
        {
            /*Сдвигает границы рандомного интервала, для более быстрого поиска

             */
            if ((positionByValue(minRandomInterval) != -1)&&(minRandomInterval < inArrayRandom.length - 1)) {minRandomInterval++;}
            /*
            int mini = minRandomInterval;
            for (int i = minRandomInterval; i < inArrayRandom.length; i++){
                if ((inArrayRandom[minRandomInterval]!= -1)&&(inArrayRandom[i] == -1)&&( i > minRandomInterval))
                {
                    mini = i;
                }
                if (mini != minRandomInterval) {break;}

            }
            return mini;
            */
        }

        private void SetMaxUseIndex() {
             /*Сдвигает границы рандомного интервала, для более быстрого поиска

             */
             if ((positionByValue(maxRandomInterval) != -1)&&(maxRandomInterval > 0)) {maxRandomInterval--;}
            /*int maxi = maxRandomInterval;
            for (int i = inArrayRandom.length -1; i >= 0; i--){
                if ((inArrayRandom[maxRandomInterval]!= -1)&&(inArrayRandom[i] == -1)&&( i < maxRandomInterval))
                {
                    maxi = i;
                }
                if (maxi != maxRandomInterval) {break;}

            }*/
            //return maxi;
        }



        private boolean isContaining (int value){

            boolean flag = false;
            for (int i = 0; i < inArrayRandom.length; i++)
            {
                if (inArrayRandom[i] == value)
                {
                  flag = true;
                  break;
                }
            }
            return flag;
        }

        private int positionByValue(int value) {
            int flag = -1;
            for (int i = 0; i < inArrayRandom.length; i++){
                if (inArrayRandom[i] == value){
                    flag = i;
                }
            }
            return flag;
        }


        RandomIterator() {
          /*создаем массив интов  inArray.length,
          идексы соотвествуют индексам  inArray значения тому рандому который мы будем брать по индексу из inArray*/

            minRandomInterval = 0;
            maxRandomInterval = inArray.length - 1;
            inArrayRandom = new int[inArray.length];
          for (int i = 0; i < inArrayRandom.length; i++)
            {
                inArrayRandom[i] = -1; /*Инициализируем невозможными значениями индексов*/
            }

            /*Рандомизируем*/

          for (int i = 0; i < inArrayRandom.length; i++ )
          {


              int randomValue = 0;
              while (inArrayRandom[i] == -1)
              {
                  randomValue = random(minRandomInterval, maxRandomInterval);
                  if (!isContaining(randomValue)) {
                      inArrayRandom[i] = randomValue;
                      if ((maxRandomInterval - minRandomInterval) > 1) {

                       SetMaxUseIndex();
                       SetMinUseIndex();
                      }

                  }

              }
          }

          /*Выставляем позицию*/
            valueposition = inArrayRandom[0];
            position = 0;

        }

        @Override
        public boolean hasNext() {
            return (position <= inArrayRandom.length - 1);
        }

        @Override
        public Object next() {
            String aValue = inArray[valueposition];
            position++;
            if (hasNext()) {
                valueposition = inArrayRandom[position];
            }
            return  aValue;
        }
    }

}

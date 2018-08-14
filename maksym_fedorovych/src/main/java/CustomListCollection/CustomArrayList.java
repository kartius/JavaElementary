package main.java.CustomListCollection;

public class CustomArrayList implements CustomList{
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
}

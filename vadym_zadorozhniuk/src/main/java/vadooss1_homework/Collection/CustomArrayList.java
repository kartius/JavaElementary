package vadooss1_homework.Collection;

import java.util.Iterator;

public class CustomArrayList implements CustomList {
    private String[] str = {};
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !(size>0);
    }

    @Override
    public boolean contains(String element) {
        boolean check = false;
        for (String i:str) {
            if(i.equals(element)){check=true;}

        }
        return check;
    }

    @Override
    public void add(String element) {
        size++;
        String[] dest = new String [size];
        for (int i = 0; i<size-1; i++) {
            dest[i]=str[i];
        }
        dest[size-1]=element;
        str=dest;

    }

    @Override
    public void add(int index, String element) {
        size++;
        if(index>=size){index=size-1;}
        String[] dest = new String [size];
        for (int i = 0; i<index; i++) {
            dest[i]=str[i];
        }
        dest[index]=element;
        for (int i = index+1; i<size; i++) {
            dest[i]=str[i];
        }

        str=dest;

    }

    @Override
    public boolean remove(String element) {
        if(contains(element)){size--;}
        int k=0;
        String[] dest = new String [size];
        for (int i = 0; i < str.length; i++) {
            if(!str[i].equals(element)){
                dest[k]=str[i];
                k++;
            }

        }
        str=dest;
        return true;
    }

    @Override
    public String remove(int index) {
        if(index<size){size--;}
        int k=0;
        String temp="";
        String[] dest = new String [size];
        for (int i = 0; i < str.length; i++) {
            if(i!=index){
                dest[k]=str[i];
                k++;
            }else{temp=str[i];}

        }
        str=dest;
        return temp;
    }

    @Override
    public void clear() {
        size=0;
        str=new String[0];

    }

    @Override
    public String get(int index) {
        if(index<size){
        return str[index];}
        return null;
    }

    @Override
    public void set(int index, String element) {
        for (int i = 0; i < str.length; i++) {
            if (i == index) {
                str[i] = element;
            }
        }

    }

    @Override
    public int indexOf(String element) {
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public Iterator iterator(){return new Itr();}

    private class Itr implements Iterator {
        int point = 0;

        @Override
        public boolean hasNext() {

            return point < size;
        }

        @Override
        public String next() {
            if (size == 0) {
                return null;
            }
            if (point < size) {
                return str[point++];
            }
            return null;

        }

        @Override
        public void remove() {
            if (size > 0) {
                str[--size] = null;
            }

        }
    }
        public Iterator backwardIterator(){return new ItrBack();}

        private class ItrBack implements Iterator{
            int point = size-1;

            @Override
            public boolean hasNext() {

                return point>=0;
            }

            @Override
            public String next() {
                if(size==0){return null;}
                if(point>=0){return str[point--];}
                return null;

            }

            @Override
            public void remove() {
                if(size>0){
                    str[--size]=null;
                }

            }


    }
    public Iterator randomIterator(){return new ItrRand();}

    private class ItrRand implements Iterator {
        int point;
        int[] randomPoint;

        ItrRand(){
            point=0;
            randomPoint = new int[size];
            for (int i = 0; i < size ; i++) {
               randomPoint[i] = i;
            }
            int temp;
            int k;
            for (int i = 0; i < size; i++) {
                temp = randomPoint[i];
                k = (int)(Math.random()*size);
                randomPoint[i]=randomPoint[k];
                randomPoint[k]=temp;

            }
        }



        @Override
        public boolean hasNext() {

            return point < size;
        }

        @Override
        public String next() {
            if (size == 0) {
                return null;
            }
            if (point < size) {
                return str[randomPoint[point++]];
            }
            return null;

        }

        @Override
        public void remove() {
            if (size > 0) {
                str[--size] = null;
            }

        }
    }

}

package lesson15HomeWork;


import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class CustomArrayList implements CustomList,Iterable {
    //constant
    private final int firstSize=0;
    String[] array=new String[firstSize];

    // Size of List
    @Override
    public int size() {
        return array.length;
    }

    // Check for empty List
    @Override
    public boolean isEmpty() {
        boolean c= true;
       if(array.length>0){
           int count=0;
           for (String s:array
                ) {
               if (s!=null) count++;
           }
           if(count>0) c=false;
       }
        return c;
    }
    // If contains element return true
    @Override
    public boolean contains(String element) {
        int count=0;
        boolean c=false;
        for (String s:array
             ) {
            if(s==element) count++;
        } if(count>0) c=true;
        return c;
    }

    //add element after last position
    @Override
    public void add(String element) {
        changeSize(array.length+1);
        array[array.length-1]=element;
    }

    //add element in index position
    @Override
    public void add(int index, String element) {
        String[] newArray=new String[array.length+1];
        if(index>array.length){changeSize(index+1); array[index]=element;}
        else if(index==0&&index<=array.length){
            if(index==0||index==array.length){
                add(element);
            }else{
                System.arraycopy(array,0,newArray,0,index);
                newArray[index]=element;
                System.arraycopy(array,index++,newArray,index++,array.length-index);
            }
        }

    }

    // Rremove element contains element
    @Override
    public boolean remove(String element) {
        boolean c=false;
        remove(indexOf(element));
        c=true;
        return c;

    }

    // remove by the index
    @Override
    public boolean remove(int index) {
        boolean c=false;
        if(index>=0&&index<array.length){
            for(int i=index;i<array.length-1;i++){
             array[i]=array[i+1];
            }
            changeSize(array.length-1);
            c=true;
        }
    return c;
    }

    //clear List
    @Override
    public void clear() {
    changeSize(0);
    }

    //get element by the index
    @Override
    public String get(int index) {

        return array[index];
    }

    //set element by the index
    @Override
    public void set(int index, String element) {
        array[index]=element;
    }

    //check index of element
    @Override
    public int indexOf(String element) {
        int c=-1;
        if(size()>0) {
            for (int i = 0;i<array.length;i++ ){
                if(array[i]==element) c=i;
            }


        }return c;
    }


    //Help method

    private void changeSize(int newSize){
        String[] newArray=new String[newSize];
        if(newSize<0) {changeSize(0);}
        else if(newSize==0) {array=newArray;}
        else if(newSize>array.length){
        System.arraycopy(array,0,newArray,0,array.length);
        array=newArray;}
        else{System.arraycopy(array,0,newArray,0, newSize);
        array=newArray;}
    }

    @Override
    public Iterator iterator() {
        Iterator<String> invertIterator=new Iterator<String>() {

            int index=array.length-1;
            @Override
            public boolean hasNext() {
                return index>=0;
            }

            @Override
            public String next() {
                return array[index--];
            }
        };


        return invertIterator;
    }

}

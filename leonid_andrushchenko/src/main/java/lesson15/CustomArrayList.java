package lesson15;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class CustomArrayList implements CustomList {
    private String [] values;
    private int size;

    public CustomArrayList(){
        values = new String[10];
        size = 0;
    }

    public CustomArrayList(String[] values){
        if(values.length == 0){
            values = new String[10];
            size = 0;
        }
        else {
            this.values = values;
            size = values.length;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String element) {
        for (int i = 0; i < size; i++)
        {
            if(values[i].equals(element))
                return  true;
        }
        return false;
    }

    @Override
    public void add(String element) {
        if(size == values.length){ // Makes array of values bigger when it doesn't have free cells
            String[] newValues = new String[values.length*2];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }

        values[size] = element;
        size++;
    }

    @Override
    public void add(int index, String element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " is not correct");

        if(size == values.length){// Makes array of values bigger when it doesn't have free cells
            String[] newValues = new String[values.length*2];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = element;
        size++;
    }

    @Override
    public boolean remove(String element) {

        for(int i = 0; i < size; i++){
            if(values[i].equals(element)){
                remove(i);
               return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " is not correct");

        String copy = values[index];
        size--;

        if(index == size - 1){
            values[index] = null;
            return copy;
        }


        System.arraycopy(values, index + 1, values, index, size - index);// removes element and moves all next elements to one cell left
        values[size] = null;// removes the last element that have already been copied
        return copy;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            values[i] = null;
        }
        size = 0;
    }

    @Override
    public String get(int index) {
        return values[index];
    }

    @Override
    public void set(int index, String element) {
        values[index] = element;
    }

    @Override
    public int indexOf(String element) {
        for (int i = 0; i < size; i++){
            if(values[i].equals(element)){
                return i;
            }
        }
        System.out.println("Element not found");
        return -1;
    }











    public Iterator backwardIterator(){
        return new BackwardIterator();
    }

    private class BackwardIterator implements Iterator
    {
        int cursor = CustomArrayList.this.size - 1; // index of next element
        int lastElement = CustomArrayList.this.size;

        @Override
        public boolean hasNext() {
            return cursor >= 0;
        }

        @Override
        public Object next() {
            if(cursor < 0)
                throw  new NoSuchElementException();

            lastElement = cursor;
            cursor--;

            return CustomArrayList.this.values[lastElement];
        }

        @Override
        public void remove() {

        }

    }










    public Iterator randomIterator(){
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator
    {
        Random random = new Random();
        int cursor = random.nextInt(CustomArrayList.this.size); // index of next element
        int lastElement = CustomArrayList.this.size;
        int processedElements = 0;// The number of elements that have already been processed
        boolean[] isProcessed = new boolean[CustomArrayList.this.size];// has values true if element from our CustomArrayList with the same index has already been processed


        @Override
        public boolean hasNext() {
            return processedElements < CustomArrayList.this.size;
        }

        @Override
        public Object next() {
            isProcessed[cursor] = true;
            lastElement = cursor;
            processedElements++;

            if(hasNext()){
            while (isProcessed[cursor]) {// searches for the element that have not been processed
                cursor = random.nextInt(CustomArrayList.this.size);
            }
            }

            return CustomArrayList.this.values[lastElement];
        }

        @Override
        public void remove() {

        }
    }
}

package ua.od.hillel.lesson_16_serialization;

import java.util.Iterator;

public interface CustomList extends Iterable {

    int size();

    boolean isEmpty();

    boolean contains(String element);

    void add(String element);

    void add(int index, String element);

    boolean remove(String element);

    String remove(int index);

    void clear();

    String get(int index);

    void set(int index, String element);

    int indexOf(String element);

    Iterator iterator();

    Iterator backwardIterator();

    Iterator randomIterator();
}
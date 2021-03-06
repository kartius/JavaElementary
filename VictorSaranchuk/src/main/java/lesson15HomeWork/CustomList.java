package lesson15HomeWork;

public interface CustomList {
    int size();
    boolean isEmpty();
    boolean contains(String element);
    void add(String element);
    void add(int index, String element);
    boolean remove(String element);
    boolean remove(int index);
    void clear();
    String get(int index);
    void set(int index, String element);

    int indexOf(String element);

}

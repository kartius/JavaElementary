package lesson12;

public class BoxG <T> {

private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public <K, V> K make(K item1, V item2){
        return item1;
    }
}

package datastructures;

public interface Queue<E> {
    void add(E element);
    E remove();
    E peek();
    boolean isEmpty();
    int size();
}

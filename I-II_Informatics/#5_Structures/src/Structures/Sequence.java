package Structures;

/**
 * Created by Mihail on 09.02.2017.
 */
public interface Sequence<T> {
    void add(T obj);
    T pop();
    T peak();
    int size();
}

package Structures;

/**
 * Created by Mihail on 09.02.2017.
 */
public class Queue<T> implements Sequence<T> {
    private static final int NMAX = 100;
    private Object[] data;
    private int i;

    public Queue(){
        data = new Object[NMAX];
        i = -1;
    }

    @Override
    public void add(T obj){
        if (i < NMAX) {
            i++;
            data[i] = obj;
        }
    }

    @Override
    public T pop() {
        T obj = (T) data[0];
        for (int i = 0; i < NMAX -1; i++) {
            data[i] = data[i + 1];
        }
        i--;
        return (T) obj;
    }

    @Override

    public T peak(){
        Object obj = data[0];
        return (T) obj;
    }

    @Override
    public int size() {
        return i + 1;
    }
}

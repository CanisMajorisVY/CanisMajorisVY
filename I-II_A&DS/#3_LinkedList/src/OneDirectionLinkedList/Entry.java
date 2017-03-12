package OneDirectionLinkedList;

/**
 * Created by Mihail on 02.03.2017.
 */
public class Entry<T> {
    private Entry<T> nextEntry;
    private T data;


    public Entry(Entry<T> nextEntry, T data){
        this.nextEntry = nextEntry;
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public Entry<T> getNext() {
        return nextEntry;
    }

    public void setNext(Entry<T> entry){
        this.nextEntry = entry;
    }

}

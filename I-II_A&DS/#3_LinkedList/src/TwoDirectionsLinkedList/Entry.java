package TwoDirectionsLinkedList;

/**
 * Created by Mihail on 02.03.2017.
 */
public class Entry<T> {
    private Entry<T> nextEntry;
    private Entry<T> previousEntry;
    private T data;


    public Entry(Entry<T> nextEntry, Entry<T> previousEntry, T data){
        this.nextEntry = nextEntry;
        this.previousEntry = previousEntry;
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public Entry<T> getNext() {
        return nextEntry;
    }

    public Entry<T> getPrevious(){
        return previousEntry;
    }

    public void setPrevious(Entry<T> entry) {
        this.previousEntry = entry;
    }

    public void setNext(Entry<T> entry){
        this.nextEntry = entry;
    }

}

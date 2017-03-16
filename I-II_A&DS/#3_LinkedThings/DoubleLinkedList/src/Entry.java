/**
 * Created by Mihail on 02.03.2017.
 */
public class Entry<T> {
    private Entry<T> nextEntry;
    private Entry<T> previousEntry;
    private T data;


    public Entry(Entry<T> previousEntry, Entry<T> nextEntry, T data){
        this.previousEntry = previousEntry;
        this.nextEntry = nextEntry;
        this.data = data;
    }

    public Entry<T> getPrevious() {
        return previousEntry;
    }

    public void setPrevious(Entry<T> previousEntry) {
        this.previousEntry = previousEntry;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Entry<T> getNext() {
        return nextEntry;
    }

    public void setNext(Entry<T> entry){
        this.nextEntry = entry;
    }

}

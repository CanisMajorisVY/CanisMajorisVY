import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

/**
 * Created by Mihail on 02.03.2017.
 */
public class Entry<T> {
    private Entry<T> entry;
    private T data;

    public Entry(Entry entry, T data){
        this.entry = entry;
        this.data = data;
    }

    public Entry getNext() {
        return entry;
    }

    public void setEntry(Entry<T> entry){
        this.entry = entry;
    }

}

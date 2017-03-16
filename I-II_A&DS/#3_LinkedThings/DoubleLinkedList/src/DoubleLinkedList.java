import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Mihail on 02.03.2017.
 */
public class DoubleLinkedList<T> {

    private int size;
    private Entry<T> head;
    private Entry<T> tail;

    public DoubleLinkedList(){
        head = new Entry<T>(null, null, null);
        tail = new Entry<T>(null, null, null);
        head.setNext(tail);     //БОЖЕМОЙЙЙЙЙЙЙЙЙЙЙЙЙЙЙ
        tail.setPrevious(head);

        this.size = 0;
    }

    public void addFirst(T ob) {
        if(ob != null) {
            head.getNext();
            if(head.getData() == null) {
                head.setData(ob);
            } else {
               head = new Entry<T>(null, head, ob);
               head.getNext().setPrevious(head);
            }
            size++;
        } else {
            throw new NullPointerException();
        }
    }

    public void addLast(T ob) {
        if(ob != null) {
            if(head.getData() == null){
                head.setData(ob);
            } else {
                if (tail.getData() == null) {
                    tail.setData(ob);
                } else {
                    tail = new Entry<T>(tail, null, ob);
                    tail.getPrevious().setNext(tail);
                }
            }
            size++;
        } else {
            throw new NullPointerException();
        }
    }

    public void addAfter(T ob, T targetOb) {
        if (ob != null && targetOb != null) {
            Entry<T> entry = head;
            while (entry.getNext() != null) {
                if (entry.getData().equals(targetOb)) {
                    entry.setNext(new Entry<T>(entry,entry.getNext(),ob));
                    entry.getNext().getNext().setPrevious(entry.getNext());
                    break;
                }
                entry = entry.getNext();
                size++;
            }
        }
    }

    public void remove(T ob){
        if (ob != null) {
            Entry<T> entry = head;
            while (entry.getNext() != null) {
                if (entry.getData().equals(ob)) {
                    entry.getPrevious().setNext(entry.getNext());
                    entry.getNext().setPrevious(entry.getPrevious());
                    size--;
                    break;
                }
                entry = entry.getNext();
            }
        }
    }

    public void merge(DoubleLinkedList<T> linkedList){
        if(linkedList.head != null && tail != null){
            tail.setNext(linkedList.head);
            linkedList.head.setPrevious(tail);
            size += linkedList.size();
            tail = linkedList.tail;
        }
    }

    public int get(T ob){
        int i = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(ob)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean has(T ob){
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(ob)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public Iterator<T> iterator(){
        return new Itr<T>();
    }

    private class Itr<T> implements Iterator<T>{

        private Entry<T> entry;

        private Itr() {
            entry = new Entry<T>(null, (Entry<T>)head, null);
        }

        @Override
        public boolean hasNext() {
            return entry.getNext() != null && entry.getNext().getData() != null;
        }

        @Override
        public T next() {
            if(hasNext()) {
                entry = entry.getNext();
                return entry.getData();
            } else {
                throw new NoSuchElementException();
            }
        }

    }

    public Iterator<T> descendingIterator(){
        return new DescendingItr<T>();
    }

    private class DescendingItr<T> implements Iterator<T>{

        private Entry<T> entry;

        private DescendingItr() {
            entry = new Entry<T>((Entry<T>)tail, null, null);
        }

        @Override
        public boolean hasNext() {
            if (entry.getPrevious() != null && entry.getPrevious().getData() != null) {
                return true;
            }

            if(entry.getPrevious() != null && entry.getPrevious().getData() == null){
                if(entry.getPrevious().getPrevious() != null) {
                    entry = entry.getPrevious();
                    return true;
                }
            }

            return false;

        }

        @Override
        public T next() {
            if(hasNext()) {
                entry = entry.getPrevious();
                return entry.getData();
            } else {
                throw new NoSuchElementException();
            }
        }

    }

}

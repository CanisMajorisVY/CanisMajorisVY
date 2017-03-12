package TwoDirectionsLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Mihail on 02.03.2017.
 */
public class LinkedList<T> {

    private int size;
    private Entry<T> header;
    private Entry<T> tail;

    public LinkedList (){
        header = new Entry<T>(tail, null, null);
        tail = new Entry<T>(null, header, null);
        this.size = 0;
    }

    public void addFirst(T ob) {
        header.setNext(new Entry<T>(header.getNext(),header,ob));
        size++;
    }

    public void addLast(T ob){
        Entry<T> entry= new Entry<T>(tail,tail.getPrevious(),ob);
        tail.getPrevious().setNext(entry);
        size++;
    }

    public void remove(T ob){
        Entry<T> entry = header;
        while (entry.getNext().getData() != ob){
            entry = entry.getNext();
        }
        Entry<T> entry1 = entry;
        entry = entry.getNext();
        entry1.setNext(entry.getNext());
        size--;
    }

    public void merge(LinkedList<T> linkedList){
        Entry<T> entry = header;
        while (entry.getNext() != null){
            entry = entry.getNext();
        }
        entry.setNext(linkedList.header.getNext());
        size += linkedList.size;

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

    public int getSize(){
        return size;
    }

    public Iterator<T> iterator(){
        return new Itr<T>();
    }

    private class Itr<T> implements Iterator<T>{

        private Entry<T> entry;
        private Itr() {
            entry = (Entry<T>)header;
        }

        @Override
        public boolean hasNext() {
            return entry.getNext() != null;
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

}

package OneDirectionLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Mihail on 02.03.2017.
 */
public class LinkedList<T> {

    private int size;
    private Entry<T> header;

    public LinkedList (){
        header = new Entry<T>(null, null);
        this.size = 0;
    }

    public void add(T ob) {
        Entry<T> entry = header;
        while (entry.getNext() != null){
            entry = entry.getNext();
        }
        entry.setNext(new Entry<T>(null, ob));
        size++;
    }

    public void addAfter(T ob, T targetOb){
        Entry<T> entry1 = header;
        Entry<T> entry2;
        while (entry1.getNext().getData() != targetOb){
            entry1 = entry1.getNext();
        }
            entry1 = entry1.getNext();

        if(entry1.getNext() != null) {
            entry2 = entry1.getNext();
            entry1.setNext(new Entry<T>(entry2, ob));
            size++;
        } else {
            entry1.setNext(new Entry<T>(null, ob));
            size++;
        }
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
        if(header != null) {
            Entry<T> entry = header;
            while (entry.getNext() != null) {
                entry = entry.getNext();
            }
            entry.setNext(linkedList.header.getNext());
            size += linkedList.size;
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

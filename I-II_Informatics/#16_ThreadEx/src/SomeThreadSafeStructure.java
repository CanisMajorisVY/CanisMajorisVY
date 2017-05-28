/**
 * Created by Mihail on 16.05.2017.
 */
public class SomeThreadSafeStructure {
    private int data1;
    private int data2;

    SomeThreadSafeStructure(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public synchronized void inc(int indexOfData) {
        if(indexOfData == 0) {
            data1++;
        } else if(indexOfData == 1) {
            data2++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void set(int indexOfData, int data) {
        if(indexOfData == 0) {
            data1 = data;
        } else if(indexOfData == 1) {
            data2 = data;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized int get(int indexOfData) {
        if(indexOfData == 0) {
            return data1;
        } else if(indexOfData == 1) {
            return data2;
        } else {
            throw new IllegalArgumentException();
        }
    }

}

import org.omg.CORBA.INTERNAL;

/**
 * Created by Mihail on 02.03.2017.
 */
public class EArray<T> {


    int j;
    Object[] ar;

    EArray(){
        j = 0;
        ar = new Object[j];
    }

    void lengthOptimizer(int l) {

        Object[] nAr = new Object[ar.length];

        for (int i = 0; i < ar.length; i++) {
            nAr[i] = ar[i];
        }

        ar = new Object[l * 2];

        for (int i = 0; i < nAr.length; i++) {
            ar[i] = nAr[i];
        }

    }

    void addElement(T p) {

        if (j >= ar.length) {
            lengthOptimizer(j);
        }

        ar[j] = p;
        j++;

    }

    void removeT(int numb) {

        ar[numb] = null;

    }


    T getElement(int numb) throws ArrayIndexOutOfBoundsException {
        if(numb < j) {
            return (T) ar[numb];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mihail on 27.04.2017.
 */
public class BoolNumbersArray {
    private boolean[] array;

    public BoolNumbersArray(boolean[] array) {
        if(array[0] == true || array.length == 1) {
            this.array = array;
        } else {
             throw new IllegalArgumentException();
        }
    }

    public BoolNumbersArray(long n) {
        if(n >= 0) {
            array = new boolean[65];
            int i = 0;
            while (n > 0) {
                array[i] = n % 2 != 0;
                n /= 2;
                i++;
            }
            boolean[] newArray = new boolean[i];
            System.arraycopy(array, 0, newArray, 0, i);
            boolean q;
            for (i = 0; i < newArray.length / 2; i++) {
                q = newArray[i];
                newArray[i] = newArray[newArray.length - i - 1];
                newArray[newArray.length - i - 1] = q;
            }
            array = newArray;
            if(array.length == 0) {
                array = new boolean[1];
                array[0] = false;
            }
        }
    }

    public BoolNumbersArray(BoolNumbersArray boolNumbersArray) {
        array = boolNumbersArray.array.clone();
    }

    public BoolNumbersArray caracubaMult (BoolNumbersArray boolNumbersArray1, BoolNumbersArray boolNumbersArray2) {
        if(boolNumbersArray1.array.length == boolNumbersArray2.array.length) {
            if(!boolNumbersArray1.array[0] || !boolNumbersArray2.array[0]) {
                return new BoolNumbersArray(new boolean[1]);
            }
            if(boolNumbersArray1.array[0] && boolNumbersArray1.array[0] && boolNumbersArray1.array.length == 1 && boolNumbersArray2.array.length == 1 ) {
                boolean[] bA = new boolean[1];
                bA[0] = true;
                return new BoolNumbersArray(bA);
            }

            BoolNumbersArray L1 = boolNumbersArray1.lPart();
            BoolNumbersArray L2 = boolNumbersArray2.lPart();
            BoolNumbersArray R1 = boolNumbersArray1.rPart();
            BoolNumbersArray R2 = boolNumbersArray2.rPart();

            BoolNumbersArray R1R2 = mult(R1, R2);
            BoolNumbersArray L1L2 = mult(L1, L2);
            BoolNumbersArray L1plR1 = add(L1, R1);
            BoolNumbersArray L2plR2 = add(L2, R2);

            L1plR1.mult(L2plR2);

            L1plR1.subtract(R1R2);
            L1plR1.subtract(L1L2);

            int ndiv2 = boolNumbersArray1.array.length / 2 + boolNumbersArray1.array.length % 2;

            L1plR1.mult2powN(ndiv2);
            L1plR1.add(R1R2);
            L1L2.mult2powN(boolNumbersArray1.array.length);
            L1plR1.add(L1L2);

            return L1plR1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private BoolNumbersArray rPart() {
        BoolNumbersArray boolNumbersArray = new BoolNumbersArray(array);
        int pos = boolNumbersArray.array.length - boolNumbersArray.array.length / 2;
        int i = pos - boolNumbersArray.array.length % 2;
        while (i < boolNumbersArray.array.length && !boolNumbersArray.array[i]) {
            i++;
        }
        i -= (pos - boolNumbersArray.array.length % 2);

        boolean[] newBA = new boolean[pos - i];

        System.arraycopy(boolNumbersArray.array, pos - boolNumbersArray.array.length % 2 + i, newBA, 0, pos - i);

        if (newBA.length == 0) {
            newBA = new boolean[1];
        }
        return new BoolNumbersArray(newBA);

    }

    private BoolNumbersArray lPart() {
        BoolNumbersArray boolNumbersArray = new BoolNumbersArray(array);
        boolean[] newBA = new boolean[boolNumbersArray.array.length / 2];
        System.arraycopy(boolNumbersArray.array, 0, newBA, 0, boolNumbersArray.array.length / 2);
        if(newBA.length == 0) {
            newBA = new boolean[1];
        }
        return new BoolNumbersArray(newBA);
    }

    public void div(BoolNumbersArray boolNumbersArray) {
        BoolNumbersArray newBNA1 = new BoolNumbersArray(1);
        BoolNumbersArray newBNA2 = new BoolNumbersArray(boolNumbersArray);
        BoolNumbersArray finalBNA = new BoolNumbersArray(0);

        boolean q = false;
        while (biggerOrSame(array, newBNA2.array)){
            newBNA2.mult2x();
            newBNA1.mult2x();
            q = true;
        }

        if(!q) {
            throw new IllegalArgumentException();
        } else {
            newBNA1.div2();
            newBNA2.div2();
        }
        while (biggerOrSame(array, boolNumbersArray.array) && biggerOrSame(newBNA2.array, boolNumbersArray.array)) {

            while (biggerOrSame(array, newBNA2.array)) {
                subtract(newBNA2);
                finalBNA.add(newBNA1);
            }
            newBNA1.div2();
            newBNA2.div2();
        }
        array = finalBNA.array;
    }

    public void div2() {
        if(array.length > 1) {
            boolean[] ar = new boolean[array.length - 1];
            System.arraycopy(array, 0, ar, 0, array.length - 1);
            array = ar;
        } else {
            array = new boolean[1];
        }
    }

    private BoolNumbersArray mult(BoolNumbersArray boolNumbersArray1, BoolNumbersArray boolNumbersArray2) {
        if(boolNumbersArray2.equals(new BoolNumbersArray(new boolean[1]))) {
            return new BoolNumbersArray(new boolean[1]);
        }
        boolean q = false;
        if(!boolNumbersArray2.array[boolNumbersArray2.array.length - 1]) {
            q = true;
        }
        boolNumbersArray2.div2();
        BoolNumbersArray newBNA = mult(boolNumbersArray1,boolNumbersArray2);
        newBNA.mult2x();
        if(q) {
            return newBNA;
        }
        newBNA.add(boolNumbersArray1);
        return newBNA;
    }

    public void mult(BoolNumbersArray boolNumbersArray) {
        array = mult(new BoolNumbersArray(array), boolNumbersArray).array;
    }

    public void standartMult(BoolNumbersArray boolNumbersArray) {
        BoolNumbersArray newBNA = new BoolNumbersArray(boolNumbersArray.array.clone());
        BoolNumbersArray finalBNA = new BoolNumbersArray(0);

        for(int i = 0; i < array.length; i++) {
            if(array[array.length - i - 1]) {
                finalBNA.add(newBNA);
            }
            newBNA.mult2x();
        }
        array = finalBNA.array;
    }

    public BoolNumbersArray mult2x() {
        if(array[0] != false) {
            boolean[] newAr = new boolean[array.length + 1];
            System.arraycopy(array, 0, newAr, 0, array.length);
            array = newAr;
            return new BoolNumbersArray(array.clone());
        } else {
            return new BoolNumbersArray(array.clone());
        }
    }

    public BoolNumbersArray mult2powN(int n) {
        if(n == 0) {
            return new BoolNumbersArray(array.clone());
        }
        if(n == 1){
            return new BoolNumbersArray(array.clone()).mult2x();
        }
        boolean[] newBA = new boolean[array.length + n];
        System.arraycopy(array, 0, newBA, 0, array.length);
        array = newBA;
        return new BoolNumbersArray(array.clone());
    }

    public void subtract(BoolNumbersArray boolNumbersArray) {
        if(array.length < boolNumbersArray.array.length) {
            throw new IllegalArgumentException();
        } else if(array.length == boolNumbersArray.array.length) {
            for(int i = 0; i < array.length; i++) {
                if(array[i] && !boolNumbersArray.array[i]){
                    break;
                }
                if(!array[i] && boolNumbersArray.array[i]) {
                    throw new IllegalArgumentException();
                }
            }
        }

        boolean q = false;

        boolean[] newArray = new boolean[array.length];

        for(int i = 0; i < boolNumbersArray.array.length; i++) {
            if(q) {
                if(array[array.length - i - 1]) {
                    array[array.length - i - 1] = false;
                    q = false;
                } else {
                    array[array.length - i - 1] = true;
                }
            }


            if(array[array.length - i - 1] && !boolNumbersArray.array[boolNumbersArray.array.length - i - 1]) {
                newArray[newArray.length - i - 1] = true;
            }

            if(!array[array.length - i - 1] && boolNumbersArray.array[boolNumbersArray.array.length - i - 1]) {
                newArray[newArray.length - i - 1] = true;
                q = true;
            }
        }
        int k = array.length - boolNumbersArray.array.length - 1;
        while (k >= 0) {
            if(array[k]) {
                if(q) {
                    q = false;
                } else {
                    newArray[k] = true;
                }
            } else {
                if(q) {
                    newArray[k] = true;
                }
            }
            k--;
        }

        k = 0;
        q = false;

        while (!q && k < newArray.length) {
            if(!newArray[k]){
                k++;
            } else {
                q = true;
            }
        }

            array = new boolean[newArray.length - k];
            System.arraycopy(newArray, k, array, 0, array.length);

    }

    private BoolNumbersArray substract(BoolNumbersArray boolNumbersArray1, BoolNumbersArray boolNumbersArray2) {
        BoolNumbersArray newBNA = new BoolNumbersArray(boolNumbersArray1.array.clone());
        newBNA.subtract(boolNumbersArray2);
        return newBNA;
    }

    public void add(BoolNumbersArray boolNumbersArray) {
        boolean[] array1;
        boolean[] array2;

        if(array.length <= boolNumbersArray.array.length) {
            array1 = array;
            array2 = boolNumbersArray.array;
        } else {
            array1 = boolNumbersArray.array;
            array2 = array;
        }

        boolean[] newArray = new boolean[array2.length];

        boolean q = false;

        for(int i = 0; i < array1.length; i++) {
            if(array1[array1.length - i - 1] && array2[array2.length - i - 1]) {
                if(q) {
                    newArray[newArray.length - i - 1] = true;
                } else {
                    q = true;
                }
            } else if(array1[array1.length - i - 1] || array2[array2.length - i - 1]) {
                if(q) {
                    q = true;
                } else {
                    newArray[newArray.length - i - 1] = true;
                }
            } else {
                if(q) {
                    newArray[newArray.length - i - 1] = true;
                    q = false;
                }
            }
        }

        for(int i = 0; i < array2.length - array1.length; i++) {
            if(array2[array2.length - array1.length - i - 1] ) {
                if(!q) {
                    newArray[array2.length - array1.length - i - 1] = true;
                }
            } else {
                if(q) {
                    newArray[array2.length - array1.length - i - 1] = true;
                    q = false;
                }
            }
        }

        if(q) {
            array = new boolean[newArray.length + 1];
            System.arraycopy(newArray, 0, array, 1, newArray.length);
            array[0] = true;
        } else {
            array = newArray;
        }
    }

    private BoolNumbersArray add(BoolNumbersArray boolNumbersArray1, BoolNumbersArray boolNumbersArray2) {
        BoolNumbersArray newBNA = new BoolNumbersArray(boolNumbersArray1.array.clone());
        newBNA.add(boolNumbersArray2);
        return newBNA;
    }

    public int[] to10Array() {
        int[] intArrOfCurrentNum = new int[array.length / 2 + 1];
        int[] intEndArr = new int[array.length / 2 + 1];

        intArrOfCurrentNum[0] = 1;


        for (int j = array.length - 1; j >= 0; j--) {

            if(array[j]) {
                for(int k = 0; k < intArrOfCurrentNum.length; k++){
                    intEndArr[k] += intArrOfCurrentNum[k];
                }
            }


            for (int i = 0; i < intArrOfCurrentNum.length; i++) {
                intArrOfCurrentNum[i] *= 2;
            }

            for (int i = 0; i < intArrOfCurrentNum.length - 1; i++) {
                if (intArrOfCurrentNum[i] > 9) {
                    intArrOfCurrentNum[i + 1] += intArrOfCurrentNum[i] / 10;
                    intArrOfCurrentNum[i] %= 10;
                }
            }
        }

        for (int i = 0; i < intEndArr.length - 1; i++) {
            if (intEndArr[i] > 9) {
                intEndArr[i + 1] += intEndArr[i] / 10;
                intEndArr[i] %= 10;
            }
        }

        int i = intEndArr.length - 1;
        for(; i >=0; i--) {
            if(intEndArr[i] > 0){
                break;
            }
        }

        intArrOfCurrentNum = new int[++i];
        System.arraycopy(intEndArr, 0, intArrOfCurrentNum, 0, i);

        int q;
        for (i = 0; i < intArrOfCurrentNum.length / 2; i++) {
            q = intArrOfCurrentNum[i];
            intArrOfCurrentNum[i] = intArrOfCurrentNum[intArrOfCurrentNum.length - i - 1];
            intArrOfCurrentNum[intArrOfCurrentNum.length - i - 1] = q;
        }

        if(intArrOfCurrentNum.length == 0) {
            return new int[1];
        }
        return intArrOfCurrentNum;

    }

    public String to10String() {
        String str = "";
        int[] arr = to10Array();

        for(int i = 0; i < arr.length; i++) {
            str += arr[i];
        }

        return str;
    }

    public int to10Int() throws Exception {
        if(array.length > 31) {
            throw new Exception();
        }
        int q = 1, n = 0;
        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i]) {
                n+= q;
            }
            q *= 2;
        }
        return n;
    }

    private boolean biggerOrSame(boolean[] a1, boolean[] a2) {
        if(a1.length > a2.length) {
            return true;
        } else if(a2.length > a1.length) {
            return false;
        } else {
            for(int i = 0; i < a1.length; i++){
                if(a1[i] && !a2[i]){
                    return true;
                }
                if(!a1[i] && a2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < array.length; i++) {
            if(array[i]) {
                str += "1";
            } else {
                str+= "0";
            }
        }
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof BoolNumbersArray)) {
            return false;
        }

        return  Arrays.equals(array, ((BoolNumbersArray) obj).array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

}

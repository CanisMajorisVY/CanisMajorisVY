import java.util.Arrays;

/**
 * Created by Mihail on 10.05.2017.
 */
public class BoolNumbersArray {

    private boolean[] array;

    public BoolNumbersArray(boolean[] array, boolean q) {
        if(!q) {
            if (array[0] == true || array.length == 1) {
                this.array = array;
            } else {
                int k = 0;
                while (k < array.length && !array[k]) {
                    k++;
                }

                boolean[] newAr = new boolean[array.length - k];
                System.arraycopy(array, k, newAr, 0, array.length - k);
                this.array = newAr;
                if (k == array.length) {
                    this.array = new boolean[1];
                }
            }
        } else {
            this.array = array;
        }

    }

    public BoolNumbersArray(boolean[] array) {
        this(array, false);
    }

    public BoolNumbersArray(long n) {
        if (n == 0) {
            array = new boolean[1];
        } else {
            if (n > 0) {
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
            }
        }
    }

    public BoolNumbersArray(BoolNumbersArray boolNumbersArray) {
        array = boolNumbersArray.array.clone();
    }

    public void add(BoolNumbersArray boolNumbersArray) {
        boolean[] array1;
        boolean[] array2;

        if (array.length <= boolNumbersArray.array.length) {
            array1 = array;
            array2 = boolNumbersArray.array;
        } else {
            array1 = boolNumbersArray.array;
            array2 = array;
        }

        boolean[] newArray = new boolean[array2.length];

        boolean q = false;

        for (int i = 0; i < array1.length; i++) {
            if (array1[array1.length - i - 1] && array2[array2.length - i - 1]) {
                if (q) {
                    newArray[newArray.length - i - 1] = true;
                } else {
                    q = true;
                }
            } else if (array1[array1.length - i - 1] || array2[array2.length - i - 1]) {
                if (q) {
                    q = true;
                } else {
                    newArray[newArray.length - i - 1] = true;
                }
            } else {
                if (q) {
                    newArray[newArray.length - i - 1] = true;
                    q = false;
                }
            }
        }

        for (int i = 0; i < array2.length - array1.length; i++) {
            if (array2[array2.length - array1.length - i - 1]) {
                if (!q) {
                    newArray[array2.length - array1.length - i - 1] = true;
                }
            } else {
                if (q) {
                    newArray[array2.length - array1.length - i - 1] = true;
                    q = false;
                }
            }
        }

        if (q) {
            array = new boolean[newArray.length + 1];
            System.arraycopy(newArray, 0, array, 1, newArray.length);
            array[0] = true;
        } else {
            array = newArray;
        }
    }

    public static BoolNumbersArray add(BoolNumbersArray boolNumbersArray, BoolNumbersArray boolNumbersArray2) {
        BoolNumbersArray newBNA = new BoolNumbersArray(boolNumbersArray.array.clone());
        newBNA.add(boolNumbersArray2);
        return newBNA;
    }

    public void subtract(BoolNumbersArray boolNumbersArray) {
        if (array.length < boolNumbersArray.array.length) {
            throw new IllegalArgumentException();
        } else if (array.length == boolNumbersArray.array.length) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] && !boolNumbersArray.array[i]) {
                    break;
                }
                if (!array[i] && boolNumbersArray.array[i]) {
                    throw new IllegalArgumentException();
                }
            }
        }

        boolean q = false;

        boolean[] newArray = new boolean[array.length];

        for (int i = 0; i < boolNumbersArray.array.length; i++) {
            if (q) {
                if (array[array.length - i - 1]) {
                    array[array.length - i - 1] = false;
                    q = false;
                } else {
                    array[array.length - i - 1] = true;
                }
            }


            if (array[array.length - i - 1] && !boolNumbersArray.array[boolNumbersArray.array.length - i - 1]) {
                newArray[newArray.length - i - 1] = true;
            }

            if (!array[array.length - i - 1] && boolNumbersArray.array[boolNumbersArray.array.length - i - 1]) {
                newArray[newArray.length - i - 1] = true;
                q = true;
            }
        }
        int k = array.length - boolNumbersArray.array.length - 1;
        while (k >= 0) {
            if (array[k]) {
                if (q) {
                    q = false;
                } else {
                    newArray[k] = true;
                }
            } else {
                if (q) {
                    newArray[k] = true;
                }
            }
            k--;
        }

        k = 0;
        q = false;

        while (!q && k < newArray.length) {
            if (!newArray[k]) {
                k++;
            } else {
                q = true;
            }
        }

        array = new boolean[newArray.length - k];
        System.arraycopy(newArray, k, array, 0, array.length);
        if (array.length == 0) {
            array = new boolean[1];
        }

    }

    public static BoolNumbersArray substract(BoolNumbersArray boolNumbersArray, BoolNumbersArray boolNumbersArray2) {
        BoolNumbersArray newBNA = new BoolNumbersArray(boolNumbersArray.array.clone());
        newBNA.subtract(boolNumbersArray2);
        return newBNA;
    }

    public BoolNumbersArray mult2x() {
        if (array[0] != false) {
            boolean[] newAr = new boolean[array.length + 1];
            System.arraycopy(array, 0, newAr, 0, array.length);
            array = newAr;
            return new BoolNumbersArray(array);
        } else {
            return new BoolNumbersArray(array);
        }
    }

    public static BoolNumbersArray mult(BoolNumbersArray boolNumbersArrayF, BoolNumbersArray boolNumbersArrayS) {
        BoolNumbersArray boolNumbersArray = new BoolNumbersArray(boolNumbersArrayF.array.clone());
        BoolNumbersArray boolNumbersArray2 = new BoolNumbersArray(boolNumbersArrayS.array.clone());
        if (boolNumbersArray2.equals(new BoolNumbersArray(new boolean[1])) || boolNumbersArray.equals(new BoolNumbersArray(new boolean[1]))) {
            return new BoolNumbersArray(new boolean[1]);
        }
        boolean q = false;
        if (!boolNumbersArray2.array[boolNumbersArray2.array.length - 1]) {
            q = true;
        }
        boolNumbersArray2.div2();
        BoolNumbersArray newBNA = mult(boolNumbersArray, boolNumbersArray2);
        newBNA.mult2x();
        if (q) {
            return newBNA;
        }
        newBNA.add(boolNumbersArray);
        return newBNA;
    }

    public void mult(BoolNumbersArray boolNumbersArray) {
        array = mult(new BoolNumbersArray(array), boolNumbersArray).array;
    }

    public void div2() {
        if (array.length > 1) {
            boolean[] ar = new boolean[array.length - 1];
            System.arraycopy(array, 0, ar, 0, array.length - 1);
            array = ar;
        } else {
            array = new boolean[1];
        }
    }

    public int to10Int() throws Exception {
        if (array.length > 31) {
            throw new Exception();
        }
        int q = 1, n = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i]) {
                n += q;
            }
            q *= 2;
        }
        return n;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                str += "1";
            } else {
                str += "0";
            }
        }
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BoolNumbersArray)) {
            return false;
        }

        int k = 0;
        while (k < array.length && !array[k]) {
            k++;
        }

        boolean[] newAr = new boolean[array.length - k];
        System.arraycopy(array, k, newAr, 0, array.length - k);

        BoolNumbersArray bar = (BoolNumbersArray) obj;
        k = 0;
        while (k < bar.array.length && !bar.array[k]) {
            k++;
        }

        boolean[] newAr1 = new boolean[bar.array.length - k];
        System.arraycopy(bar.array, k, newAr1, 0, bar.array.length - k);

        return Arrays.equals(newAr1, newAr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

}

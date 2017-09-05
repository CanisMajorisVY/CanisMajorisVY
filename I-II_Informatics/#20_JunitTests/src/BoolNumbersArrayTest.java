import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mihail on 30.05.2017.
 */

public class BoolNumbersArrayTest {

    @Test
    public void add() throws Exception {
        int n = 100;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                BoolNumbersArray boolNumbersArray1 = new BoolNumbersArray(i);
                BoolNumbersArray boolNumbersArray2 = new BoolNumbersArray(j);

                BoolNumbersArray boolNumbersArray3 = BoolNumbersArray.add(boolNumbersArray1, boolNumbersArray2);

                Assert.assertEquals(i + j, boolNumbersArray3.to10Int());
            }
        }
    }

    @Test
    public void substract() throws Exception {
        int n = 100;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                BoolNumbersArray boolNumbersArray1 = new BoolNumbersArray(i);
                BoolNumbersArray boolNumbersArray2 = new BoolNumbersArray(j);

                if(i >= j) {
                    BoolNumbersArray boolNumbersArray3 = BoolNumbersArray.substract(boolNumbersArray1, boolNumbersArray2);
                    Assert.assertEquals(i - j, boolNumbersArray3.to10Int());
                }
            }
        }
    }

    @Test
    public void mult2x() throws Exception {
        int n = 100;
        for(int i = 1; i < n; i++) {
            BoolNumbersArray boolNumbersArray1 = new BoolNumbersArray(i);
            boolNumbersArray1.mult2x();

            Assert.assertEquals(i*2, boolNumbersArray1.to10Int());
        }
    }

    @Test
    public void mult() throws Exception {
        int n = 100;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                BoolNumbersArray boolNumbersArray1 = new BoolNumbersArray(i);
                BoolNumbersArray boolNumbersArray2 = new BoolNumbersArray(j);

                BoolNumbersArray boolNumbersArray3 = BoolNumbersArray.mult(boolNumbersArray1, boolNumbersArray2);

                Assert.assertEquals(i * j, boolNumbersArray3.to10Int());
            }
        }
    }

    @Test
    public void div2() throws Exception {
        int n = 100;
        for(int i = 1; i < n; i++) {
            BoolNumbersArray boolNumbersArray1 = new BoolNumbersArray(i);
            boolNumbersArray1.div2();
            Assert.assertEquals(i/2, boolNumbersArray1.to10Int());
        }
    }

    @Test
    public void to10Int() throws Exception {
        int n = 100;
        BoolNumbersArray boolNumbersArray;
        for(int i = 0; i < n; i++) {
            boolNumbersArray = new BoolNumbersArray(i);
            Assert.assertEquals(i, boolNumbersArray.to10Int());
        }
    }

    @Test
    public void toStringTest() throws Exception {
        String s1 = "0";
        int n = 10;
        BoolNumbersArray boolNumbersArray = new BoolNumbersArray(0);
        Assert.assertTrue(s1.equals(boolNumbersArray.toString()));
        s1 = "1";
        boolNumbersArray = new BoolNumbersArray(1);
        Assert.assertTrue(s1.equals(boolNumbersArray.toString()));
        int pow = 1;
        for( int i = 0; i < n; i++ ) {
            pow *= 2;
            if (i % 2 == 0) {
                s1 += "0";
                boolNumbersArray.mult2x();
            } else {
                s1 = "1" + s1;
                boolNumbersArray = BoolNumbersArray.add(boolNumbersArray, new BoolNumbersArray(pow));
            }
            Assert.assertTrue(s1.equals(boolNumbersArray.toString()));
        }

    }

}
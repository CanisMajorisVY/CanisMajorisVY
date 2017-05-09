/**
 * Created by Mihail on 10.05.2017.
 */
public class MatrixMulter {

    public static int[][] sum(int[][] ar1, int[][] ar2) {
        if(ar1.length > 0 && ar1[0].length > 0 && ar2.length > 0 && ar2[0].length > 0) {
            if (ar1.length == ar2.length && ar1[0].length == ar2[0].length) {
                int[][] newInt = new int[ar1.length][ar1[0].length];
                for(int i = 0; i < ar1.length; i++) {
                    for(int j = 0; j < ar1[0].length; j++) {
                        newInt[i][j] = ar1[i][j] + ar2[i][j];
                    }
                }
                return  newInt;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }

    }

    public static int[][] sub(int[][] ar1, int[][] ar2) {
        if(ar1.length > 0 && ar1[0].length > 0 && ar2.length > 0 && ar2[0].length > 0) {
            if (ar1.length == ar2.length && ar1[0].length == ar2[0].length) {
                int[][] newInt = new int[ar1.length][ar1[0].length];
                for(int i = 0; i < ar1.length; i++) {
                    for(int j = 0; j < ar1[0].length; j++) {
                        newInt[i][j] = ar1[i][j] - ar2[i][j];
                    }
                }
                return  newInt;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }

    }

    public static int[][] standartMult(int[][] ar1, int[][] ar2) {
        if(ar1.length > 0 && ar1[0].length > 0 && ar2.length > 0 && ar2[0].length > 0) {
            if (ar1[0].length == ar2.length) {
                int[][] newAr = new int[ar1[0].length][ar2.length];
                int s = 0;
                for(int i = 0; i < ar1.length; i++) {
                    for(int j = 0; j < ar2[0].length; j ++){
                        for(int k = 0; k < ar1[0].length; k++){
                            s += ar1[i][k] * ar2[k][j];
                        }
                        newAr[i][j] = s;
                        s = 0;
                    }
                }
                return newAr;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int[][] strassenMult(int[][]ar1, int[][] ar2) {
        if(ar1.length > 0 && ar1[0].length > 0 && ar2.length > 0 && ar2[0].length > 0) {
            int k = 1;
            for (int i = 0; i < 30; i++) {
                if (ar1.length == k && ar2.length == k && ar1[0].length == k && ar2[0].length == k) {
                    k = 0;
                    break;
                }
                k *= 2;
            }
            if(k == 0) {
                if(ar1.length < 65 ) {
                    return standartMult(ar1,ar2);
//                    int[][] newInt = new int[1][1];
//                    newInt[0][0] = ar1[0][0] * ar2[0][0];
//                    return newInt;
                }

                int[][] p1 = strassenMult(sum(LH(ar1),RD(ar1)),sum(LH(ar2),RD(ar2)));
                int[][] p2 = strassenMult(sum(LD(ar1),RD(ar1)),LH(ar2));
                int[][] p3 = strassenMult(LH(ar1),sub(RH(ar2),RD(ar2)));
                int[][] p4 = strassenMult(RD(ar1),sub(LD(ar2),LH(ar2)));
                int[][] p5 = strassenMult(sum(LH(ar1),RH(ar1)),RD(ar2));
                int[][] p6 = strassenMult(sub(LD(ar1),LH(ar1)),sum(LH(ar2),RH(ar2)));
                int[][] p7 = strassenMult(sub(RH(ar1),RD(ar1)),sum(LD(ar2),RD(ar2)));

                int[][] CLH = sum(sub(p4,p5),sum(p1,p7));
                int[][] CRH = sum(p3, p5);
                int[][] CLD = sum(p2, p4);
                int[][] CRD = sum(sub(p1,p2),sum(p3,p6));

                int[][] newAr = new int[ar1.length][ar1.length];
                for(int i = 0; i < newAr.length / 2; i++) {
                    for(int j = 0; j < newAr.length / 2; j++) {
                        newAr[i][j] = CLH[i][j];
                        newAr[i][j  + newAr.length / 2] = CRH[i][j];
                        newAr[i + newAr.length / 2][j] = CLD[i][j];
                        newAr[i + newAr.length / 2][j + newAr.length / 2] = CRD[i][j];
                    }
                }
                return newAr;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int[][] LH (int[][] ar) {
        int[][] newAr = new int[ar.length / 2][ar.length / 2];
        for(int i = 0; i < ar.length / 2; i++) {
            for(int j = 0; j < ar.length / 2; j++) {
                newAr[i][j] = ar[i][j];
            }
        }
        return newAr;
    }

    public static int[][] RH (int[][] ar) {
        int[][] newAr = new int[ar.length / 2][ar.length / 2];
        for(int i = 0; i < ar.length / 2; i++) {
            for(int j = 0; j < ar.length / 2; j++) {
                newAr[i][j] = ar[i][j + ar.length / 2];
            }
        }
        return newAr;
    }

    public static int[][] RD (int[][] ar) {
        int[][] newAr = new int[ar.length / 2][ar.length / 2];
        for(int i = 0; i < ar.length / 2; i++) {
            for(int j = 0; j < ar.length / 2; j++) {
                newAr[i][j] = ar[i + ar.length / 2][j + ar.length / 2];
            }
        }
        return newAr;
    }

    public static int[][] LD (int[][] ar) {
        int[][] newAr = new int[ar.length / 2][ar.length / 2];
        for(int i = 0; i < ar.length / 2; i++) {
            for(int j = 0; j < ar.length / 2; j++) {
                newAr[i][j] = ar[i + ar.length / 2][j];
            }
        }
        return newAr;
    }

}

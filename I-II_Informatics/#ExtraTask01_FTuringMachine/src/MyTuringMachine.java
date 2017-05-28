import java.util.Arrays;

/**
 * Created by Mihail on 20.05.2017.
 */
public class MyTuringMachine {
    private Transitison[][] transitisionTable;
    private String currentState;
    private String finalState;

    public MyTuringMachine(String[][] transitisionTable, String firstState, String finalState) {
        this.transitisionTable = new Transitison[transitisionTable.length][transitisionTable[0].length];
        for(int i = 0; i < transitisionTable.length; i++) {
            for(int j = 0; j < transitisionTable[0].length; j++) {
                this.transitisionTable[i][j] = new Transitison(transitisionTable[i][j]);
            }
        }
        this.currentState = firstState;
        this.finalState = finalState;
    }

    public String tapeOn(String tape) {
        char[] charTape = new char[tape.length() + 2];
        System.arraycopy(tape.toCharArray(), 0, charTape, 1, tape.length());
        int i = 1;
        while (!currentState.equals(finalState)) {
            if(i == 0) {
                char[] newCharTape = new char[charTape.length + 1];
                System.arraycopy(charTape, 0, newCharTape, 1, charTape.length);
                charTape = newCharTape;
                i++;
            }

            if(i == charTape.length - 1) {
                char[] newCharTape = new char[charTape.length + 1];
                System.arraycopy(charTape, 0, newCharTape, 0, charTape.length);
                charTape = newCharTape;
            }
            int j1 = 0;
            while (j1 < transitisionTable[0].length && !transitisionTable[0][j1].stateFromTape.equals(currentState)) {
                j1++;
            }
            if(j1 == transitisionTable[0].length) {
                throw new IllegalStateException();
            }
            int j2 = 0;
            while (j2 < transitisionTable.length && charTape[i] != transitisionTable[j2][0].letterFromTape) {
                j2++;
            }
            if(j2 == transitisionTable.length) {
                throw new IllegalArgumentException();
            }

            charTape[i] = transitisionTable[j2][j1].letterForWrite;
            currentState = transitisionTable[j2][j1].nextState;
            if (transitisionTable[j2][j1].dirForMove == 'R' || transitisionTable[j2][j1].dirForMove == 'r') {
                i++;
            }
            if (transitisionTable[j2][j1].dirForMove == 'L' || transitisionTable[j2][j1].dirForMove == 'l') {
                i--;
            }
        }

        String str = "";
        for(int q = 0 ; q < charTape.length; q++) {
            str += charTape[q];
        }
        return str;
    }
}

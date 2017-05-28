/**
 * Created by Mihail on 20.05.2017.
 */
public class Transitison {
    public String stateFromTape;
    public char letterFromTape;
    public String nextState;
    public char letterForWrite;
    public char dirForMove;

    Transitison(String str) {
        String[] array = str.split(",");
        if(array.length != 5) {
            throw new IllegalArgumentException();
        }
        stateFromTape = array[0];
        letterFromTape = array[1].charAt(0);
        nextState = array[2];
        letterForWrite = array[3].charAt(0);
        dirForMove = array[4].charAt(0);
        if(dirForMove != 'r' && dirForMove != 'R' && dirForMove != 'L' && dirForMove != 'l' && dirForMove != 'S' && dirForMove != 's' ) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return stateFromTape + " " + letterFromTape + " " + nextState + " " + letterForWrite + " " + dirForMove;
    }
}

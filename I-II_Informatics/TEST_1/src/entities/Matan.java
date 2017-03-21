package entities;

/**
 * Created by Mihail on 21.03.2017.
 */
public class Matan  extends Subject {

    private int balls;

    public Matan(){
        balls = 50;
    }


    public void add(int ball) {
        balls -= ball;
        if (balls < 0) {
            balls = 0;
        }
    }

    public void add(int note, int nOfTask ){
        if(nOfTask == 1){
            passFirstBlockOfNumbers(note);
        } else if(nOfTask == 2) {
            passSecondBlockOfNumbers(note);
        } else if(nOfTask == 3){
            passTest1(note);
        } else if(nOfTask == 4) {
            passTest2(note);
        } else throw  new IllegalArgumentException();
    }

    public void passFirstBlockOfNumbers(int rightNumbers){
        if(rightNumbers > 15 || rightNumbers < 0) {
            throw new IllegalArgumentException();
        } else {
            add(15 - rightNumbers);
        }

    }

    public void passSecondBlockOfNumbers(int rightNumbers){
        if(rightNumbers > 15 || rightNumbers < 0) {
            throw new IllegalArgumentException();
        } else {
            add(15 - rightNumbers);
        }

    }

    public void passTest1(int note){
        if(note > -1 && note < 6){
            add((note - 5) * 2);
        } else throw new IllegalArgumentException();
    }

    public void passTest2(int note){
        if(note > -1 && note < 6){
            add((note - 5) * 2);
        } else throw new IllegalArgumentException();
    }

    public int getBall(){
        return balls;
    }

}

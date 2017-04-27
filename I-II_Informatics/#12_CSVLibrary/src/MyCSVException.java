/**
 * Created by Mihail on 15.04.2017.
 */
public class MyCSVException extends Exception {
    public MyCSVException(){
    }

    public MyCSVException(String msg) {
        super(msg);
    }

    public MyCSVException(String msg, Throwable ex) {
        super(msg, ex);
    }
}

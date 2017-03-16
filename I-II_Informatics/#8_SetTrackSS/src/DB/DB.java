package DB;

import java.io.IOException;

/**
 * Created by Mihail on 13.03.2017.
 */
public interface DB {
    void add(Object obj);
    void remove(int i);
    void readDBFromFile() throws DbException;
    void writeDBInFile() throws DbException;
}

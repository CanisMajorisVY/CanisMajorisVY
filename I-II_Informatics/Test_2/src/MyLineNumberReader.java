import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

/**
 * Created by Mihail on 11.05.2017.
 */

public class MyLineNumberReader extends BufferedReader{
    private int currentLineNumber;

    public MyLineNumberReader(Reader reader) {
        super(reader);
        currentLineNumber = 0;
    }

    public String readLine() throws IOException {
        String newString = super.readLine();
        if (newString != null) {
            currentLineNumber++;
        }
        return newString;
    }

    public int read() throws IOException {
        int c = super.read();
        while (c == '\r') {
            currentLineNumber++;
            c = super.read();
        }
        if(c == '\n') {
            currentLineNumber++;
        }
        return c;
    }

    public int read(char[] cbuf, int off, int len) throws IOException {
        int i;
        int c;
        for(i = 0; i < len - off && (c = read()) != -1; i++) {
            cbuf[i] = (char)c;
        }
        return i + 1;
    }

    public long skip(long n) throws IOException {
        if(n < 0) {
            throw  new IllegalArgumentException();
        }

        long i;
        for(i = 0; i < n && read() != -1; i++) {
            read();
            i++;
        }
        return i;
    }

    public void setLineNumber(int n) {
        currentLineNumber = n;
    }

    public int getLineNumber(){
        return currentLineNumber;
    }

}

import java.io.*;
import java.util.*;

/**
 * Created by Mihail on 19.04.2017.
 */
public class MyProperties extends Hashtable<String, String> {

    private MyProperties defaults;

    public MyProperties() {

    }

    public String getProperty(String key) {
        return get(key);
    }

    public String getProperty(String key, String defaultValue) {
        if(contains(key)) {
            return get(key);
        } else {
            return (defaultValue);
        }
    }

    public Enumeration<String> propertyNames() {
        return keys();
    }

    public void list(PrintStream PS) throws IOException {
        PrintWriter PW = new PrintWriter(PS);
        list(PW);
    }

    public void list(PrintWriter PW) {
        Set<String> kS = keySet();
        Iterator<String> iterator = kS.iterator();
        String key, val;
        while (iterator.hasNext()) {
            key = iterator.next();
            val = get(key);
            PW.write(key + " = " + val + "\n");
        }
        PW.close();
    }

    public void load(InputStream IS) throws IOException {
        load(new InputStreamReader(IS));
    }

    public void load(Reader reader) throws IOException {
        clear();
        try(BufferedReader BR = new BufferedReader(reader)) {
            String str;
            while ((str = BR.readLine()) != null) {
                str = str.replaceAll(" ", "");
                String[] strA = str.split("=");
                put(strA[0], strA[1]);
            }
        } catch (IOException ex) {
            throw new IOException("Ошибка чтения");
        }
    }

    public void setProperty(String key, String val){
        put(key, val);
    }

    public void store(OutputStream OS, String comments) throws IOException {
        store(new OutputStreamWriter(OS), comments);
    }

    public void store(OutputStream OS) throws IOException {
        store(new OutputStreamWriter(OS));
    }

    public void store(Writer writer) throws IOException{
        store(writer, null);
    }
    public void store(Writer writer, String comments) throws IOException {
        try(BufferedWriter BW = new BufferedWriter(writer)) {
            Set<String> kS = keySet();
            Iterator<String> iterator = kS.iterator();
            String key, val;
            if(comments != null) {
                BW.write("#" + comments + "\n");
            }
            while (iterator.hasNext()) {
                key = iterator.next();
                val = get(key);
                BW.write(key + " = " + val + "\n");
            }
        } catch (IOException ex) {
            throw new IOException("Ошибка записи");
        }
    }

    public Set<String> stringPropertyNames() {
        return keySet();
    }

}

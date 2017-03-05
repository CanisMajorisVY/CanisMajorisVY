package etc;

import data.DbException;
import entities.Track;

/**
 * Created by Mihail on 02.03.2017.
 */
public class FormatFactory {


    public static Formatter formate (Track track) throws DbException{
        if(track.getFormat().equals("mp3")) {
            return new Mp3();
        } else
        if(track.getFormat().equals("flaac")) {
            return new Flaac();
        } else
        if(track.getFormat().equals("wav")) {
            return new Wav();
        } else {
            throw new DbException("ошиюка в формате файла");
        }
    }
}

package etc;

import data.DbException;
import entities.Track;

/**
 * Created by Mihail on 28.02.2017.
 */
interface Player {
    public void play(Track track) throws DbException;
    public void stop();

}

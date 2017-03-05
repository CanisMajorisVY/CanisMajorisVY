package Comparisons;

import java.util.Comparator;

/**
 * Created by Mihail on 28.02.2017.
 */
public class TrackNameComparator implements Comparator<Track> {

    @Override
    public int compare(Track track1, Track track2){
        return track1.getTitle().compareTo(track2.getTitle());
    }

}

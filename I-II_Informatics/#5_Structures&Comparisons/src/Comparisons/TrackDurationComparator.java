package Comparisons;

import java.util.Comparator;

/**
 * Created by Mihail on 28.02.2017.
 */

public class TrackDurationComparator implements Comparator<Track> {

    @Override
    public int compare(Track track1, Track track2) {
        if(track1.getDuration() > track2.getDuration()) {
            return 1;
        } else if(track1.getDuration() < track2.getDuration()) {
            return -1;
        }
        return 0;
    }
}

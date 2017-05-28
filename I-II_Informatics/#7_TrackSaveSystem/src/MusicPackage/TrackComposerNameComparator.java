package MusicPackage;

import java.util.Comparator;

/**
 * Created by Mihail on 05.03.2017.
 */
public class TrackComposerNameComparator implements Comparator<Track> {

    @Override
    public int compare(Track track1, Track track2) {
        return track1.getComposer().getName().compareTo(track2.getComposer().getName());
    }
}

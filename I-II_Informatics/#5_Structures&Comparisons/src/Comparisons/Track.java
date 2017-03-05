package Comparisons;

/**
 * Created by Mihail on 28.02.2017.
 */
public class Track implements Comparable<Track>{
    private Composer composer;
    private String title;
    private int duration;

    public Track(String title, int duration, Composer composer ) {
        this.title = title;
        this.duration = duration;
        this.composer = composer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    @Override
    public int compareTo(Track track){
        return title.compareTo(track.getTitle());
    }

}

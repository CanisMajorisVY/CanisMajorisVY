package Comparisons;

/**
 * Created by Mihail on 28.02.2017.
 */
public class Track {
    private Composer composer;
    private String title;
    private int duration;

    public Track(String title, int duration, Composer composer ) {
        this.title = title;
        this.duration = duration;
        this.composer = composer;
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

}

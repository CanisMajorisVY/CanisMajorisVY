import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mihail on 10.05.2017.
 */
public class MusicMachine {
    private MidiChannel[] channels = null;
    private Synthesizer synth = null;

    public MusicMachine() throws Exception {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
            channels[0].programChange(11);
        } catch (MidiUnavailableException ex) {
            throw new Exception(ex);
        }
    }

    public void close() {
        synth.close();
    }

    public void playSound(int note) throws Exception{
        channels[0].noteOn(note, 200);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            throw new Exception(ex);
        }
        channels[0].noteOff(note);
    }
}

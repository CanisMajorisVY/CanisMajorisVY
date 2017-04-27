import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.nio.channels.InterruptedByTimeoutException;

/**
 * Created by Mihail on 25.04.2017.
 */
public class App {
    public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        MidiChannel[] channels = synth.getChannels();

        channels[0].programChange(11);

        channels[0].noteOn(5, 120);
        Thread.sleep(500);
        channels[0].noteOff(5);
        Thread.sleep(50);
        channels[0].noteOn(5, 120);
        Thread.sleep(500);
        channels[0].noteOff(5);
        Thread.sleep(50);
        channels[0].noteOn(5, 120);
        Thread.sleep(500);
        channels[0].noteOff(5);
        Thread.sleep(50);
        channels[0].noteOn(6, 120);
        Thread.sleep(200);
        channels[0].noteOff(5);
        Thread.sleep(50);
        channels[0].noteOn(8, 120);
        Thread.sleep(150);
        channels[0].noteOff(5);
        Thread.sleep(50);
        channels[0].noteOn(5, 120);
        Thread.sleep(500);
        channels[0].noteOff(5);
        Thread.sleep(50);
        channels[0].noteOn(6, 120);
        Thread.sleep(200);
        channels[0].noteOff(5);
        Thread.sleep(50);
        channels[0].noteOn(8, 120);
        Thread.sleep(150);
        channels[0].noteOff(5);
        Thread.sleep(50);
        channels[0].noteOn(5, 120);
        Thread.sleep(500);
        channels[0].noteOff(5);
        Thread.sleep(50);





    }
}

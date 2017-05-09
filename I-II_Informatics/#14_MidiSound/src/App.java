import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.nio.channels.InterruptedByTimeoutException;

/**
 * Created by Mihail on 25.04.2017.
 */
public class App {
    public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                MyFrame frame = new MyFrame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });


    }
}

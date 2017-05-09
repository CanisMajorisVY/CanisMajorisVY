import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Mihail on 10.05.2017.
 */
public class MyFrame extends JFrame {

    private JLabel label;

    public MyFrame(){
        super();
        try {
            createGUI();
        } catch (Exception ex){
        }
    }

    private void createGUI() throws Exception{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setFocusable(true);

        label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);

        MusicMachine musicMachine = new MusicMachine();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    musicMachine.playSound((e.getKeyCode() - 48) * 10);
                } catch (Exception ex) {
                }
            }
        });

        panel.add(label, BorderLayout.CENTER);
        setPreferredSize(new Dimension(100,100));
        getContentPane().add(panel);
    }

}

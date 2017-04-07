import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/**
 * !!Will not disclose name since jar files can be accessed too easily!!
 * Purpose: Be a piano of piece and calmness.
 * Here: Class for going through the arraylists and initializing the needed components.
 * 
 * @author QinBeans(Chin beans;RF)
 * @version 1.9
 */
public class Sounds
{
    public Sounds(ArrayList<Chords> get)
    {
        ArrayList<Chords> chords = get;
        Play play = new Play();
        JFrame frame = new JFrame("Piano(WIP)");
        JPanel panel = new JPanel();
        JTextField field = new JTextField(1);
        JLabel label = new JLabel("Click the text field to play using keyboard->");
        String in = "";
        int x=0;
        int y=0;
        Buttons.enable(panel,"");
        Keybinds.bind(panel);
        field.addKeyListener(new KeyListener(){
                @Override
                public void keyTyped(KeyEvent e){
                }

                @Override
                public void keyPressed(KeyEvent ev){
                    int code = ev.getKeyChar();
                    play.play(chords,code,panel);
                }

                @Override
                public void keyReleased(KeyEvent e){
                }
            });
        label.setForeground(Color.WHITE);
        panel.add(label);
        panel.add(field);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel.setBackground(Color.DARK_GRAY);
        frame.setSize(1900, 250);
        frame.setVisible(true);
        frame.add(panel);
    }
}

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.HashMap;
import java.awt.image.BufferedImage;
/**
 * !!Will not disclose name since jar files can be accessed too easily!!
 * Purpose: Be a piano of piece and calmness.
 * Here: class for buttons in the menu.
 * 
 * @author QinBeans(Chin beans;RF)
 * @version 1.9
 */
public class Buttons extends JPanel
{
    private static String[] keycount = {"A0","Bb0","B0"
        ,"C1","Db1","D1","Eb1","E1","F1","Gb1","G1","Ab1","A1","Bb1","B1"
        ,"C2","Db2","D2","Eb2","E2","F2","Gb2","G2","Ab2","A2","Bb2","B2"
        ,"C3","Db3","D3","Eb3","E3","F3","Gb3","G3","Ab3","A3","Bb3","B3"
        ,"C4","Db4","D4","Eb4","E4","F4","Gb4","G4","Ab4","A4","Bb4","B4"
        ,"C5","Db5","D5","Eb5","E5","F5","Gb5","G5","Ab5","A5","Bb5","B5"
        ,"C6","Db6","D6","Eb6","E6","F6","Gb6","G6","Ab6","A6","Bb6","B6"
        ,"C7","Db7","D7","Eb7","E7","F7","Gb7","G7","Ab7","A7","Bb7","B7"
        ,"C8",};
    public static void enable(JPanel panel){
        //Cut for ease of coding (Section 7)
        String in = "";
        BufferedImage squareImg = new BufferedImage(5, 25, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = squareImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x=0;
        int y=0;
        for(String comb:keycount){
            Map<String,JButton> attempt = new HashMap<String,JButton>();
            attempt.put(comb,new JButton());
            JButton holder = attempt.get(comb);
            if(comb.contains((CharSequence)"b")){
                g2.setColor(Color.BLACK);
                g2.fillRect(x, y, 5, 25);
                g2.dispose();
                holder.setIcon(new ImageIcon(squareImg));
                holder.setBackground(Color.BLACK);
                holder.setOpaque(true);
            }else{
                g2.setColor(Color.WHITE);
                g2.fillRect(x, y, 5, 50);
                g2.dispose();
                holder.setIcon(new ImageIcon(squareImg));
                holder.setBackground(Color.WHITE);
                holder.setOpaque(true);
            }
            holder.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ev){
                        try {
                            // Open an audio input stream.
                            URL url = this.getClass().getClassLoader().getResource(comb+".wav");
                            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                            // Get a sound clip resource.
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioIn);
                            clip.start();
                        } catch (UnsupportedAudioFileException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (LineUnavailableException e) {
                            e.printStackTrace();
                        }
                        //Chords(char for keysignature,int for which key,char for value of character for keybind)
                    }
                });
            panel.add(holder);
        }

    }
}
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Map;
import java.awt.Color;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.net.URL;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import java.util.HashMap;
/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons
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
    public static void enable(JPanel panel,String name){
        for(String comb:keycount){
            Map<String,JButton> attempt = new HashMap<String,JButton>();
            attempt.put(comb,new JButton(comb));
            JButton holder = attempt.get(comb);
            if(name==comb){
                holder.setBackground(Color.YELLOW);
                holder.setForeground(Color.RED);
                holder.setOpaque(true);
            }else if(comb.contains((CharSequence)"b")){
                holder.setBackground(Color.BLACK);
                holder.setForeground(Color.RED);
                holder.setOpaque(true);
            }else{
                holder.setBackground(Color.WHITE);
                holder.setForeground(Color.RED);
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
                    }
                });
            panel.add(holder);
        }
    }
    public static void disable(JPanel panel){
        for(String comb:keycount){
            Map<String,JButton> attempt = new HashMap<String,JButton>();
            attempt.put(comb,new JButton());
            JButton holder = attempt.get(comb);
            panel.remove(holder);
        }
    }
}

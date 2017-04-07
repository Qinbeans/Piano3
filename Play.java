import java.util.ArrayList;
import java.io.IOException;
import javax.swing.JPanel;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
/**
 * !!Will not disclose name since jar files can be accessed too easily!!
 * Purpose: Be a piano of piece and calmness.
 * Here: Class for playing the sounds.
 * 
 * FIX:play notes at right time and glow on pseudo keyboard
 * 
 * @author QinBeans(Chin beans;RF)
 * @version 1.9
 */
public class Play
{
    public Play(){
    }

    public void play(ArrayList<Chords> chords,int cv,JPanel panel){
        for(Chords chord:chords){
            if(cv==chord.getChar()){
                Buttons.disable(panel);//deletes buttons in the keycount array list to remap keys
                try {
                    // Open an audio input stream.
                    String comb = "";
                    int in = chord.getInt();
                    String out = chord.toString();
                    if((chord.getKey().charAt(0)!=98&&chord.getKey().charAt(0)!=99&&(in)>7)){
                        in-=7;
                        comb=chord.getKey().toUpperCase()+"b"+(in);
                    }else if((chord.getKey().charAt(0)==98)&&(in>=8)){
                        in-=8;
                        comb="Bb"+(in);
                    }else{
                        comb=chord.getKey().toUpperCase()+""+(in);
                    }
                    Buttons.enable(panel,comb);//sends copy of comb which also exists in keycount array
                    URL url = chord.getClass().getClassLoader().getResource(comb+".wav");
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
                Buttons.disable(panel);//does another remap
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                Buttons.enable(panel,"");//remaps complete
            }
        }
    }
}
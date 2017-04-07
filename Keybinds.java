import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;
/**
 * !!Will not disclose name since jar files can be accessed too easily!!
 * Purpose: Be a piano of piece and calmness.
 * Here: Place where things are shortened for a more easy time for processing.
 * 
 * @author QinBeans(Chin beans;RF)
 * @version 1.9
 */
public class Keybinds
{
    public static void bind(JPanel panel){
        JButton settings = new JButton("Settings");
        int[][] keycount = {{16,17,8,14,14,7,14},{0,0,1,1,1,1,1}};
        config config = new config();
        ArrayList<Chords> chords = config.read("default.txt");
        settings.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JFrame frame = new JFrame("Settings");
                    JPanel pane = new JPanel();
                    for(int kp = 0;kp<7;kp++){
                        for(int it = keycount[1][kp];it<keycount[0][kp];it++){
                            String comb = (char)(97+kp)+""+it;
                            Map<String,JTextField> attempt = new HashMap<String,JTextField>();
                            attempt.put(comb,new JTextField(comb,2));
                            JTextField holder = attempt.get(comb);
                            int get = kp;
                            int c = it;
                            holder.addKeyListener(new KeyListener(){
                                    @Override
                                    public void keyTyped(KeyEvent ev){
                                        char code = ev.getKeyChar();
                                        if(get<1)
                                            chords.set(c,new Chords((char)(get+97),c,code));
                                        else if(get<2)
                                            chords.set(c+15,new Chords((char)(get+97),c,code));
                                        else if(get<3)
                                            chords.set(c+31,new Chords((char)(get+97),c,code));
                                        else if(get<4)
                                            chords.set(c+39,new Chords((char)(get+97),c,code));
                                        else if(get<5)
                                            chords.set(c+53,new Chords((char)(get+97),c,code));
                                        else if(get<6)
                                            chords.set(c+67,new Chords((char)(get+97),c,code));
                                        else if(get<7)
                                            chords.set(c+74,new Chords((char)(get+97),c,code));
                                        //Chords(char for keysignature,int for which key,char for value of character for keybind)
                                    }

                                    @Override
                                    public void keyPressed(KeyEvent ev){
                                    }

                                    @Override
                                    public void keyReleased(KeyEvent ev){
                                    }
                                });
                            pane.add(holder);
                        }
                    }
                    JButton enter = new JButton("Exit");
                    enter.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ev){
                                frame.dispose();
                                config.write(chords);
                                new Sounds(chords);
                            }
                        });
                    pane.add(enter);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    pane.setBackground(Color.DARK_GRAY);
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                    frame.add(pane);
                }
            });
        panel.add(settings);
    }
}

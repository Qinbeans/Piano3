import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.Arrays;
/**
 * !!Will not disclose name since jar files can be accessed too easily!!
 * Purpose: Be a piano of piece and calmness.
 * Here: Class to convert txt to and arraylist and back.
 * 
 * @author QinBeans(Chin Beans;RF)
 * @version 1.9
 */
public class config
{
    public config(){

    }

    public void write(ArrayList<Chords> in){
        try{
            ArrayList<String> hold = new ArrayList<String>();
            Path file = Paths.get("config.txt");
            Files.deleteIfExists(file);
            for(Chords element:in){
                String temp = element.toString();
                if(element.getInt()<10)
                    hold.add(temp+"|"+element.getChar());
                else if(element.getInt()==10)
                    hold.add(element.getKey()+"a|"+element.getChar());
                else if(element.getInt()==11)
                    hold.add(element.getKey()+"b|"+element.getChar());
                else if(element.getInt()==12)
                    hold.add(element.getKey()+"c|"+element.getChar());
                else if(element.getInt()==13)
                    hold.add(element.getKey()+"d|"+element.getChar());
                else if(element.getInt()==14)
                    hold.add(element.getKey()+"e|"+element.getChar());
                else if(element.getInt()==15)
                    hold.add(element.getKey()+"f|"+element.getChar());
            }
            Files.write(file, hold, Charset.forName("UTF-8"));
        }catch(IOException e){
        }
    }

    public ArrayList<Chords> read(String in){
        ArrayList<Chords> chords = new ArrayList<Chords>();
        try{
            Path file = Paths.get(in);
            Files.readAllLines(file,Charset.forName("UTF-8")).forEach(line->{
                    if(line.length()==4){
                        String[] tempa=line.split("");
                        char f = tempa[0].charAt(0);
                        int s = 0;
                        if ((int)tempa[1].charAt(0)>=97){
                            s=tempa[1].charAt(0)-87;
                        }else{
                            s=tempa[1].charAt(0)-48;
                        }
                        char t = tempa[3].charAt(0);
                        chords.add(new Chords(f,s,t));
                    }
                });
        }catch(IOException e){
        }
        return chords;
    }
}
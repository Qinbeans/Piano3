/**
 * !!Will not disclose name since jar files can be accessed too easily!!
 * Purpose: Be a piano of piece and calmness.
 * Here:Class for saving chords in a compact manner.
 * 
 * @author QinBeans(Chin beans;RF)
 * @version 1.9
 */
public class Chords
{
    private char key;
    private int numOfk = 0;
    private char c = 0;
    public Chords(char myk, int myint,char ch)
    {
        key = myk;
        numOfk = myint;
        c = ch;
    }
    public String toString()
    {
        return (""+key+numOfk);
    }
    public String getKey()
    {
        return ""+key;
    }
    public int getInt()
    {
        return numOfk;
    }
    public char getChar()
    {
        return c;
    }
}

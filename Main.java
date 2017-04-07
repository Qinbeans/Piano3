/**
 * !!Will not disclose name since jar files can be accessed too easily!!
 * Purpose: Be a piano of piece and calmness.
 * 
 * @author QinBeans(Chin beans;RF)
 * @version 1.9
 */
public class Main
{
    public static void main(String[] args)
    {
        config start = new config();
        new Sounds(start.read("config.txt"));
    }
}
    
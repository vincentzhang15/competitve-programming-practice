import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Alphabet
{
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        try
        {
            s = br.readLine();
            br.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        for(int i=97; i<97+6; i++)
        {
            char c = (char)i;
            if(s.indexOf(c) == -1)
            {
                System.out.println(c);
                break;
            }
        }
    }
}
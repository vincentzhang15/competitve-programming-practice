import java.io.*;
import java.util.*;

public class main
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temperature = 999;
        String city = " ";
        
        for(;;)
        {
            String [] s = br.readLine().split(" ");
            if(Integer.parseInt(s[1]) < temperature)
            {
                temperature = Integer.parseInt(s[1]);
                city = s[0];
            }
                
            if(s[0].equals("Waterloo"))
            {
                System.out.println(city);
                return;
            }
        }
    }
}
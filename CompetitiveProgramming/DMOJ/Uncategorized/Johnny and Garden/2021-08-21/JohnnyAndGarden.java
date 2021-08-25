import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class JohnnyAndGarden
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int idx = line1.indexOf('.');
        if(idx != -1)
            System.out.println("\"" + line1.substring(0, idx) + "\" - " + line1.substring(idx+1).toLowerCase());
        else
        {
            String line2 = br.readLine();
            System.out.println("\"" + line1 + "\" - " + line2.toLowerCase());
        }
    }
}
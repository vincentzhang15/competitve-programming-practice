import java.io.*;

public class Main
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(br.readLine());
        int t2 = Integer.parseInt(br.readLine());
        
        if(t1 - t2 > t2) // output is 3
            System.out.println(3);
        else // output is > 3
        {
            int count = 4;
            while(true)
            {
                int t3 = t1 - t2;
                int t4 = t2 - t3;
            
                if(t3 < t4)
                {
                    System.out.println(count);
                    break;
                }
                count += 1;
                
                t1 = t2;
                t2 = t3;
            }
        }
    }
}
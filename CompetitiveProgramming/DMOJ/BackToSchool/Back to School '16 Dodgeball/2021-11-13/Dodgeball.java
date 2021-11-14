import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Program to find the number of valid group choices.
 * See Dodgeball.py for details.
 * @author Vincent Zhang
 * @since 13 November 2021
 */
public class Dodgeball
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    final long MOD = 1000000007;

    String readLine()
    {
        try
        {
            return br.readLine();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        return null;
    }

    String nextToken()
    {
        while(st == null || !st.hasMoreTokens())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        try
        {
            return Integer.parseInt(nextToken());
        }
        catch(NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }
        return -1;
    }

    void brClose()
    {
        try
        {
            br.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    void run()
    {
        int n = nextInt() + 1;
        String[] names = (readLine() + " -").split(" ");

        long choices = 0;
        int idxPrev = 0;
        char name = names[idxPrev].charAt(0);
        for(int i=1; i<n; i++)
        {
            if(!(names[i].charAt(0) == name))
            {
                int len = i - idxPrev;
                choices += (( ( ( ((((len%MOD)%MOD) * (((((len%MOD)%MOD) + (1%MOD)%MOD))%MOD))%MOD) / (2%MOD)) ) % MOD )%MOD);

                idxPrev = i;
                name = names[idxPrev].charAt(0);
            }
        }
        System.out.println(choices%MOD);
    }

    public static void main(String[] args)
    {
        Dodgeball d = new Dodgeball();
        d.run();    
    }
}
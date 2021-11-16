import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CrazyFencing
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

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
        int n = nextInt();
        int[] b = new int[n+1];
        int[] h = new int[n];

        for(int i=0; i<=n; i++)
            b[i] = nextInt();
        for(int i=0; i<n; i++)
            h[i] = nextInt();
        
        int ans = 0;
        for(int i=0; i<n; i++)
            ans += (b[i] + b[i+1]) * h[i];
        System.out.println(ans / 2.0);
    }

    public static void main(String[] args)
    {
        CrazyFencing cf = new CrazyFencing();
        cf.run();
    }
}
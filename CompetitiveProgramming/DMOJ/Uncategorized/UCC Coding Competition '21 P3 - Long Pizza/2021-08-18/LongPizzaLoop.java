import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LongPizzaLoop
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

    void run()
    {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();
        int r = nextInt();

        long s = 0;
        for(int i=0; i<r; i++)
        {
            int a = nextInt();
            int b = nextInt();
            int lo = Math.max(a, x);
            int hi = Math.min(b, y);
            int v = hi - lo + 1;

            if(v > 0)
                s += v;
        }
        System.out.println(s);
    }

    public static void main(String[] args)
    {
        LongPizzaLoop lpl = new LongPizzaLoop();
        lpl.run();
    }
}
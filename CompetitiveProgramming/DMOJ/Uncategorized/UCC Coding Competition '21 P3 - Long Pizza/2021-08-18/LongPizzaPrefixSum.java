import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LongPizzaPrefixSum
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

        long[] data = new long[n+2];
        for(int i=0; i<r; i++)
        {
            int a = nextInt();
            int b = nextInt();
            data[a] += 1;
            data[b+1] -= 1;
        }
        for(int i=2; i<=n; i++)
        {
            data[i] += data[i-1];
        }
        long sum = 0;
        for(int i=x; i<=y; i++)
        {
            sum += data[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args)
    {
        LongPizzaPrefixSum lpps = new LongPizzaPrefixSum();
        lpps.run();
    }
}
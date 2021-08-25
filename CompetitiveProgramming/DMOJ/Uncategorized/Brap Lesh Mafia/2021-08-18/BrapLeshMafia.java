/*
4 12
1 4
2 9
3 8
5 5

11
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BrapLeshMafia
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

    long nextLong()
    {
        try
        {
            return Long.parseLong(nextToken());
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
        long n = nextLong();
        long m = nextLong();

        long sum = 0;
        for(int i=0; i<n; i++)
        {
            long a = nextLong();
            long b = nextLong();
            sum = (sum + a * b) % m;
        }
        brClose();
        System.out.println(sum);
    }

    public static void main(String[] args)
    {
        BrapLeshMafia a = new BrapLeshMafia();
        a.run();    
    }
}
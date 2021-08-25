// https://stackoverflow.com/questions/231767/what-does-the-yield-keyword-do
// https://stackoverflow.com/questions/29424349/implementing-long-division-using-a-generator-function-in-python


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Fractions
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String nextToken()
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

    static long nextLong()
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

    static long gcdEuclidean(long a, long b)
    {
        if(a == 0)
            return b;
        return gcdEuclidean(b%a, a);
    }

    static long multiples(long v, long d, long c)
    {
        if(d%v != 0)
            return c;
        return multiples(v, d/v, ++c);
    }

    public static void main(String[] args)
    {
        long t = nextLong();
        for(long i=0; i<t; i++)
        {
            /*
            String n = nextToken();
            String dStr = nextToken();
            long d = Long.parseLong(dStr);


            int minLen = dStr.length();
            long p;
            if(minLen > n.length())
            {
                p = Long.parseLong(n);
                n = "";
            }
            else
            {
                p = Long.parseLong(n.substring(0, minLen));
                n = n.substring(minLen);
            }

            long count = 0;
            for(; count <= 1000;)
            {
                if(p == 0)
                    break;

                while(p < d)
                {
                    if(n.length() == 0)
                    {
                        p *= 10;
                        count++;
                    }
                    else
                    {
                        p = p * 10 + Character.getNumericValue(n.charAt(0));
                        n = n.substring(1);
                    }
                }
                p -= p / d * d;
            }
            

            if(count > 1000)
                System.out.println(-1);
            else
                System.out.println(count);
            */

            long n = nextLong();
            long d = nextLong();
            long g = gcdEuclidean(n, d);
            n /= g;
            d /= g;

            long reduced = d;
            while(reduced % 2 == 0)
                reduced/=2;
            while(reduced % 5 == 0)
                reduced/=5;

            /*
            long m2 = multiples(2, d, 0);
            long m5 = multiples(5, d, 0);
            long reduced = d / (long)Math.pow(2, m2) / (long)Math.pow(5, m5);
            */

            if(reduced == 1)
            {
                // System.out.println(Math.max(m2, m5));
                int j = 0;
                for(; n % d != 0; j++)
                {
                    n = n * 10 % d;
                }
                System.out.println(j);

            }
            //else if(reduced == 0)
                //System.out.println(0);
            else
                System.out.println(-1);
            
        }
    }
}
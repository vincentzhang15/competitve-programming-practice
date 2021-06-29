import java.util.*;
import java.io.*;

public class Goldfinger
{
	static boolean [] notPrime;
	static void sieve()
	{
		notPrime = new boolean [16001];
		for(int i = 2; i <= 16000; i++)
			if(!notPrime[i])
				for(int j = 2; j <= 16000/i; j++)
					notPrime[i*j] = true;
	}

	public static void main (String [] args) throws IOException
	{
		sieve();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == -1) break;
			
			for(int i = 1; i <= n/2; i++)
			{
				if(!notPrime[i] && !notPrime[n-i])
					System.out.println(i + " " + (n-i));
			}
			
			System.out.println();
		}
	}
}
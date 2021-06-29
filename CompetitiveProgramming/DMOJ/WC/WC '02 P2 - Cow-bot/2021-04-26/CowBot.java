import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class CowBot
{
	public static final int MAX = 214783648;
	static boolean[] notPrime = new boolean[MAX];
	
	static void sieve()
	{
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i = 2; i < MAX; i++)
		{
			for(int j = 2; !notPrime[i] && i*j < MAX; j++)
				notPrime[i*j] = true;
		}
	}
	
	static boolean isPrime(long n)
	{
		//return !notPrime[n];
		if(n == 1)
			return false;
		for(long i = 2; i < (long)Math.sqrt(n); i++)
		{
			if(n%i == 0)
				return false;
		}
		return true;
	}
	
	public static void main (String [] args) throws IOException
	{
		//sieve();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String[] line = br.readLine().split(" ");
			long a = Long.parseLong(line[0]);
			int b = Integer.parseInt(line[1]);
			
			for(int j = 0; j < b; j++)
			{
				String s = a + "";
				if(isPrime(a))
				{
					a *= 11;
				}
				else if(Math.ceil(Math.sqrt(a)) == a)
				{
					a += Long.parseLong(new StringBuilder(s).reverse().toString());
				}
				else if((new StringBuilder(s).reverse().toString()).equals(s))
				{
					a = Long.parseLong(s + "4");
				}
				else if(s.charAt(0) == '2')
				{
					a = Long.parseLong("2" + s);
				}
				else if(s.contains("7"))
				{
					a = Long.parseLong(s.substring(0, s.length()-1));
				}
				else if(a % 6 == 0)
				{
					a = Long.parseLong(s.substring(1));
				}
				else if(s.length()%2 == 0)
				{
					a = Long.parseLong(s.substring(0, s.length()/2) + "1" + s.substring(s.length()/2));
				}
				else
				{
					a += 231;
				}
			}
			System.out.println(a);
		}
	}
}
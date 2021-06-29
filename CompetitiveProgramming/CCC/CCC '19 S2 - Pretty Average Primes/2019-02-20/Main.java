import java.util.*;
import java.io.*;

public class Main
{
	static TreeSet<Integer> prime = new TreeSet<Integer>();
	static boolean isPrime(int n)
	{
		for (int i = 2; i <= n / 2; i++)
			if (n % i == 0)
				return false;
		return true;
	}	
	static void calculatePrime(int n)
	{
		for(int i = n; i >= 2; i--)
		{
			if(prime.contains(i))
				return;
			if(isPrime(i))
				prime.add(i);
		}
	}
	static void pair (int n)
	{
		calculatePrime(n);
		Iterator<Integer> it = prime.iterator();
		while(it.hasNext())
		{
			int temp = it.next();
			if(isPrime(n-temp))
			{
				System.out.println(temp + " " + (n-temp));
				break;
			}
		}
	}
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			pair(2*n);
		}
	}
}
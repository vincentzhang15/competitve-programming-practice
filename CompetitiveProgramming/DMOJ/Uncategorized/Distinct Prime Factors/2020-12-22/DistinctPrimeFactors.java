import java.util.*;
import java.io.*;

public class DistinctPrimeFactors
{
	static boolean [] notPrime = new boolean [1000001];
	static int a, b;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static void eratosthenes()
	{
		for(int i = 2; i <= 1000000; i++)
			if(!notPrime[i])
				for(int j = i; j <= 1000000/i; j++)
					notPrime[i*j] = true;
	}
	
	static void calc(int n)
	{
		int sum = 0;
		for(int i = n; i >= 2; i--)
			if(!notPrime[i] && n % i == 0)
				sum++;
		System.out.println(sum);
	}
	
	public static void main (String [] args) throws IOException
	{
		eratosthenes();
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		
		for(int i = a; i <= b; i++)
			calc(i);
	}
}
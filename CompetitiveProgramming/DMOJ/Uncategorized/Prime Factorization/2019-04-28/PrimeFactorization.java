import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class PrimeFactorization
{
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static ArrayList<Integer> answers = new ArrayList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int a;
	
	static void calculate()
	{
		for(int j = primes.size()-1; j >= 0; j--)
		{
			//System.out.println(primes.get(j) + ":" + primes.size() + ":" + j + ":" + a + ":" + (a % primes.get(j) == 0));
			if(a % primes.get(j) == 0)
			{
				answers.add(primes.get(j));
				a/=primes.get(j);
				return;
			}
		}
	}
	
	static void sieve(int S)
	{
		boolean [] notPrime = new boolean [S+1];
		for(int i = 2; i < S; i++)
			if(!notPrime[i])
			{
				primes.add(i);
				for(int j = 2; j <= S/i; j++)
					notPrime[i*j] = true;
			}
	}
	
	static void print()
	{
		for(int i = answers.size()-1; i >= 0; i--)
			System.out.format("%d ", answers.get(i));
		System.out.format("\n");
		answers = new ArrayList<Integer>();
	}
	public static void main (String [] args) throws IOException
	{
		int n = Integer.parseInt(br.readLine());
		int max = -1;
		int [] data = new int [n];
		for(int i = 0; i < n; i++)
		{
			int b = Integer.parseInt(br.readLine());
			data[i] = b;
			if(data[i] > max)
				max = data[i];
		}
		sieve(max);
		
		for(int i = 0; i < n; i++)
		{
			a = data[i];
			while(a != 1)
			{
				calculate();
			}
			print();
		}
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ItamiAndCandy
{
	public static final int MAX = 148734 + 1; // 1 <= n <= 148 734
	static boolean[] notPrime = new boolean[MAX]; 
	
	static void sieveEratosthenes()
	{
		notPrime[0] = notPrime[1] = true;
		for(int i = 2; i < MAX; i++)
			for(int j = 2; !notPrime[i] && i*j < MAX; j++)
				notPrime[i*j] = true;
	}
	
	public static void main(String[] args) throws IOException
	{
		sieveEratosthenes();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int n = Integer.parseInt(line[0]);
		int copy = n;
		int x = Integer.parseInt(line[1]);
		
		int total = 0;
		for(int i = 2; i <= copy; i++)
		{
			n = copy;
			if(!notPrime[i])
			{
				n -= i;
				
				total += n/x+1;
				if(n == 0)
					continue;
				
				n--;
				total += n/x+1;
			}
		}
		System.out.println(total);
	}
}
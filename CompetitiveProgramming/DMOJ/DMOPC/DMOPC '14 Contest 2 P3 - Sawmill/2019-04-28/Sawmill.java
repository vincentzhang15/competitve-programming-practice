import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Sawmill
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer [] e = new Integer [n];
		Integer [] l = new Integer [n];
		
		String [] line1 = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
			e[i] = Integer.parseInt(line1[i]);
		String [] line2 = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
			l[i] = Integer.parseInt(line2[i]);
		
		Arrays.sort(e);
		Arrays.sort(l);
		
		long sum = 0;
		for(int i = 0; i < n; i++)
			sum += e[i] * l[n-i-1];
		
		System.out.println(sum);
	}
}
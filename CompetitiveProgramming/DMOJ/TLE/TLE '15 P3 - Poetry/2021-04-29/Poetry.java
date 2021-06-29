import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Poetry
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] limits = new int[n];
		
		for(int i = 0; i < n; i++)
			limits[i] = Integer.parseInt(br.readLine());
		
		String line = br.readLine() + " ";
		int first = 0;
		int last = 0;
		for(int i = 0; first < line.length(); i++)
		{
			int limit = limits[i%n];
			last = first + limit;
			last = line.lastIndexOf(" ", last);
			
			if(last < first)
			{
				System.out.println(new String(line.substring(first, first+limit)));
				first += limit;
			}
			else
			{
				System.out.println(new String(line.substring(first, last)));
				first = last + 1;
			}
		}
	}
}
import java.util.*;
import java.io.*;

public class Luggage
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line1 = br.readLine().split(" ");
		Integer n = Integer.parseInt(line1[0]);
		Integer k = Integer.parseInt(line1[1]);
		
		String [] line2 = br.readLine().split(" ");
		Integer [] data = new Integer [n];
		Integer sum = 0;
		for(Integer i = 0; i < n; i++)
		{
			data[i] = Integer.parseInt(line2[i]);
			sum += data[i];
		}
		Arrays.sort(data);

		Integer count = 0;
		Integer max = 0;
		for(Integer i = n-1; i >= 0; i--)
		{
			count = 0;
			for(Integer j = 0; j < n; j++)
			{
				if(data[j] <= data[i] && data[j] >= data[i]-k)
					count++;
			}
			if(count > max)
				max = count;
		}
		System.out.println(max);
	}
}
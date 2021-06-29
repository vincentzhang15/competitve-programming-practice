import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);

		TreeSet<Integer> list = new TreeSet<Integer>();
		String [] line2 = br.readLine().split(" ");
		int count = 0;
		int sum = 0;
		for(int i = 0; i < n; i++)
		{
			count++;
			if(count == k)
			{
				count = 0;
				if(list.last() < Integer.parseInt(line2[i]))
				{
					i--;
					sum += list.last();
					list.clear();
					continue;
				}
				else
				{
					list.add(Integer.parseInt(line2[i]));
					sum += list.last();
					list.clear();
				}
			}
			else
				list.add(Integer.parseInt(line2[i]));
			//System.out.println(i + ":"+list);
			
		}
		System.out.println(sum);
	}
}
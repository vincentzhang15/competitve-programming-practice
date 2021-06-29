import java.util.*;
import java.io.*;

public class Efficiency
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line1 = br.readLine().split(" ");
		int r = Integer.parseInt(line1[0]);
		int c = Integer.parseInt(line1[1]);
		char [][] data = new char [r][c];
		int hx = 0, hy = 0;
		
		for(int i = 0; i < r; i++)
		{
			String line = br.readLine();
			for(int j = 0; j < line.length(); j++)
			{
				data[i][j] = line.charAt(j);
				if(data[i][j] == 'H')
				{
					hx = i;
					hy = j;
				}
			}
		}
		
		int max = -1;
		int sum = 0;
		for(int i = hx; i >= 0; i--) // top
			if(data[i][hy] == 'C')
				sum++;
		max = Math.max(max, sum);

		sum = 0;
		for(int i = hx; i < r; i++) // bottom
			if(data[i][hy] == 'C')
				sum++;
		max = Math.max(max, sum);

		sum = 0;
		for(int i = hy; i < c; i++) // right
			if(data[hx][i] == 'C')
				sum++;
		max = Math.max(max, sum);
		
		sum = 0;
		for(int i = hy; i >= 0; i--) // right
			if(data[hx][i] == 'C')
				sum++;
		max = Math.max(max, sum);
		
		System.out.println(max);
	}
}
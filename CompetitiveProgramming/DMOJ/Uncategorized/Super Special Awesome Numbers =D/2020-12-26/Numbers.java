import java.util.*;
import java.io.*;

public class Numbers
{
	static int [] square;
	static void generateSquare()
	{
		square = new int [999];
		for(int i = 2; i <= 1000; i++)
			square[i-2] = i*i;
	}
	
	static boolean [] data;
	static void number()
	{
		data = new boolean [1000001];
		for(int k = 1; k <= 1000000; k++)
		{
			loop:
			{
				String s = String.valueOf(k);
				int sum = 0;
				for(int j = 0; j < s.length(); j++)
					sum += (int)(s.charAt(j) - '0');
				if(sum % 2 != 0)
					continue;

				for(int j = 1; j < s.length(); j++)
					if(s.charAt(j) - '0' <= s.charAt(j-1) - '0') // +1
						break loop;
				
				for(int j : square)
				{
					//System.out.println(k + ":" + j + ":" + (k % j));
					if(k % j == 0)
						break loop;
				}
				data[k] = true;
			}
			//System.out.println(k);
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		generateSquare();
		number();
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++)
		{
			String [] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			
			int count = 0;
			for(int j = a; j <= b; j++)
				if(data[j])
					count++;
			System.out.println(count);
		}
	}
}
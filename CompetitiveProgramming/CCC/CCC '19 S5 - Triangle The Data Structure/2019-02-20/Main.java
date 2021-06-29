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

		int [][] data = new int [3000][3000];
		for(int i = 0; i < n; i++)
		{
			String [] inLine = br.readLine().split(" ");
			for(int j = 0; j < inLine.length; j++)
			{
				if(Integer.parseInt(inLine[j]) == 0)
					data[i][j] = -1;
				else
					data[i][j] = Integer.parseInt(inLine[j]);
			}
		}
		TreeSet<Integer> list = new TreeSet<Integer>();
		int sum = 0;
		for(int i = 0; i < n-k+1; i++)
		{
			for(int j = 0; j < n-k+1; j++)
			{
				if(data[i][j] == 0)
					break;
				int b = 0;
				for(int a = 0; a < k; a++)
				{
					//System.out.println("ENTER 1");
					for(int B = 0; B < b+1; B++)
					{
						//System.out.println("ENTER 2");
						if(data[i+a][j+B] != -1)
							list.add(data[i+a][j+B]);
					}
					b++;
					
				}
				//System.out.println(list);
				sum += list.last();
				list.clear();
			}
		}
		System.out.println(sum);

		/*
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
				System.out.print(data[i][j] + " ");
			System.out.println();
		}
		*/
	}
}
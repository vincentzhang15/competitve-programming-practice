import java.io.*;
import java.util.*;

public class WaitTime
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [][] data = new int [n][3]; // 0: receive, 1: sent
		for(int i = 0; i < n; i++)
		{
			data[i][0] = 0;
			data[i][1] = 0;
			data[i][2] = 1;
		}
		
		int index = 0;
		for(int i = 0; i < n; i++)
		{
			String [] line = br.readLine().split(" ");
			if(line[0].equals("R"))
			{
				data[index][0] = 0;
				data[index][1] = Integer.parseInt(line[1]);
				index++;
			}
			else if(line[0].equals("S"))
			{
				data[index][0] = 1;
				data[index][1] = Integer.parseInt(line[1]);
				index++;
			}
			else // W
				data[index-1][2] = Integer.parseInt(line[1]);
		}
		
		/*
		for(int i = 0; i < n; i++)
		{
			System.out.println(data[i][0] + ":" + data[i][1] + ":" + data[i][2]);			
		}
		*/
		//System.out.println(index); // end at index, up to index-1
		
		TreeMap<Integer, Integer> output = new TreeMap<Integer, Integer>();
		for(int i = 0; i < index; i++)
		{
			if(data[i][0] == 0) // find pair
			{
				int sum = -1;
				for(int j = i+1; j < index; j++)
				{
					if(data[j][0] == 1 && data[j][1] == data[i][1])
					{
						sum = 0;
						for(int k = i; k < j; k++)
						{
							sum += data[k][2];
						}
						break;
					}
				}
				if(output.containsKey(data[i][1]))
					output.put(data[i][1], output.get(data[i][1])+sum);
				else
					output.put(data[i][1], sum);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : output.entrySet())
		{
			System.out.println(entry.getKey() + " " + ((entry.getValue()==0)?("-1"):(entry.getValue())));
		}
	}
}
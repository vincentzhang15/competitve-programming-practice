import java.util.*;
import java.io.*;

public class Prase
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> data = new TreeMap<String, Integer>();
		int warn = 0;
		for(int i = 1; i <= n; i++)
		{
			String name = br.readLine();
			if(data.containsKey(name))
				data.put(name, data.get(name)+1);
			else
				data.put(name, 1);
			int others = i - data.get(name);
			if(data.get(name) >= others + 2)
				warn++;
		}
		System.out.println(warn);
	}
}
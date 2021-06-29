import java.util.*;
import java.io.*;

public class Speech
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeMap<String, String> data = new TreeMap<String, String>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++)
		{
			String [] line = br.readLine().split(" ");
			data.put(line[1], line[0]);
		}
		
		String line = br.readLine();
		line = line.substring(0, line.length()-1);
		String [] all = line.split(" ");
		
		for(int i = 0; i < all.length; i++)
			if(data.containsKey(all[i]))
				all[i] = data.get(all[i]);
		
		for(int i = 0; i < all.length; i++)
			if(i == all.length-1)
				System.out.print(all[i]);
			else
				System.out.print(all[i] + " ");
		System.out.println(".");
	}
}
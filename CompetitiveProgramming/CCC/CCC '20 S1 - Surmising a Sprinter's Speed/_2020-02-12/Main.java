import java.io.*;
import java.util.*;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashMap <Integer, Integer> data = new HashMap <Integer, Integer>();
		for(int i = 0; i < n; i++)
		{
			String [] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			
			data.put(b, a);
		}
		
		for(int i = 0; i < n; i++)
		{
			System.out.println(data.key() + data.value());
		}
	}
}
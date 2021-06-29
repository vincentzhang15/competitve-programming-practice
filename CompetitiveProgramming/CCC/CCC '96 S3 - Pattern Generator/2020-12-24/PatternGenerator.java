import java.util.*;
import java.io.*;

public class PatternGenerator
{
	static void calc(int n, int k)
	{
		
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < loop; i++)
		{
			System.out.println("The bit patterns are");
			String [] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);
			calc(n, k);
			System.out.println();
		}
	}
}
import java.io.*;
import java.util.*;

public class Censor
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String [] line = br.readLine().split(" ");
			for(String s : line)
			{
				if(s.length() == 4)
					System.out.print("**** ");
				else
					System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
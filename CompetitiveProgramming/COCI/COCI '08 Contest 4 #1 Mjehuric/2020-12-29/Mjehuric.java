import java.util.*;
import java.io.*;

public class Mjehuric
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		int [] s = new int [5];
		for(int i = 0; i < 5; i++)
			s[i] = Integer.parseInt(line[i]);
		
		boolean yes = false;
		while(!yes)
		{
			for(int i = 1; i < 5; i++)
			{
				if(s[i] < s[i-1])
				{
					int temp = s[i];
					s[i] = s[i-1];
					s[i-1] = temp;
					
					for(int n : s)
						System.out.print(n + " ");
					System.out.println();
				}
			}
			for(int i = 1; i < 5; i++)
			{
				if(s[i] < s[i-1])
					break;
				if(i == 4)
					yes = true;
			}
		}
	}
}
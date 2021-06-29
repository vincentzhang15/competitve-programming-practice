import java.util.*;
import java.io.*;

public class Trener
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] data = new int [26];
		for(int i = 0; i < n; i++)
		{
			char c = br.readLine().charAt(0);
			data[c-'a']++;
		}
		
		boolean b = true;
		for(int i = 0; i < 26; i++)
		{
			if(data[i] >= 5)
			{
				System.out.print((char)((int)'a' + i));
				b = false;
			}
		}
		if(b)
			System.out.print("PREDAJA");
		System.out.println();
	}
}
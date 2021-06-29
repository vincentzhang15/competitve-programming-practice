import java.util.*;
import java.io.*;

public class Maternity
{
	static String m, d;
	
	static boolean possible(String p1, String p2, char c)
	{
		if(p1.toUpperCase().equals(p1) || p2.toUpperCase().equals(p2)) // AA AA
			return c - 'a' < 0; // A
		if(p1.toLowerCase().equals(p1) && p2.toLowerCase().equals(p2)) // aa aa
			return !(c - 'a' < 0); // A
		return true;
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = br.readLine();
		d = br.readLine();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String line = br.readLine();
			boolean end = true;
			for(int j = 0; j < line.length(); j++)
				end = end && possible(m.substring(j*2, j*2+1+1), d.substring(j*2, j*2+1+1), line.charAt(j));
			System.out.println((end)?("Possible baby."):("Not their baby!"));
		}
	}
}
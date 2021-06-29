import java.io.*;
import java.util.*;

public class Main
{
	static TreeSet<String> data = new TreeSet<String>();
	static void calc(String s, String a)
	{

		if (s.length() == 0)
		{
			data.add(a);
			return;
		}
		
		for (int i = 0; i < s.length(); i++)
		{
			String rest = s.substring(0, i) + s.substring(i + 1);
			calc(rest, a + s.charAt(i));
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String h = br.readLine();
		
		calc(n, "");
		
/*		for(int i = 0; i < n.length(); i++)
		{
			for(int j = 0; j < n.length(); j++)
			{
				String part = n.substring(0, i) + n.substring(i+1);
				char c = n.charAt(i);
				
				String newStr = "";
				newStr = part.substring(0, j) + c + part.substring(j);
				
				data.add(newStr);
			System.out.println(newStr);
			}
			System.out.println();
		}
*/		
		int count = 0;
		for(String s : data)
		{
			if(h.indexOf(s) != -1)
				count++;
		}
		System.out.println(count);
	}
}
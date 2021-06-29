import java.util.*;
import java.io.*;

public class Binary
{
	static void calc(String s)
	{
		int n = (s.length()%4 != 0)?(4-(s.length()%4)):(0);
		for(int i = 0; i < n; i++)
			s = "0" + s;
		for(int i = 0; i < s.length(); i++)
		{
			if((i+1)%4 == 0)
				System.out.print(s.charAt(i) + " ");
			else
				System.out.print(s.charAt(i));
		}
		System.out.println();
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			int m = Integer.parseInt(br.readLine());
			calc(Integer.toBinaryString(m));
		}
	}
}
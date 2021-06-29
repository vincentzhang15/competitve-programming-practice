import java.util.*;
import java.io.*;

public class Slom
{
	static int n;
	static String s;
	static String original;
	
	static void calc()
	{
		if(s.length()%2==0)
		{
			for(int i = s.length()-3; i >= 0; i--)
				if(i%2!=0)
					s = s.substring(0, i) + s.substring(i+1) + s.charAt(i);
		}
		else
		{
			for(int i = s.length()-2; i >= 0; i--)
				if(i%2!=0)
					s = s.substring(0, i) + s.substring(i+1) + s.charAt(i);
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = br.readLine();
		original = s;
		String [] data = new String [10000];
		int ind = 0;
		//n %= (int)(s.substring(1).chars().distinct().count());
		
		int period = n+1;
		data[ind++] = s;
		for(int i = 0; i < n; i++)
		{
			calc();
			if(s.equals(original))
			{
				period = i+1;
				break;
			}
			data[ind++] = s;
		}
		System.out.println(data[n%period]);
	}
}
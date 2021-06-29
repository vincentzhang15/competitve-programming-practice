import java.util.*;
import java.io.*;

public class Plachta
{
	static int gcd(int a, int b)
	{
		if(a % b == 0)
			return b;
		return gcd(b, a%b);
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++)
		{
			String [] line = br.readLine().split(" ");
			int n1 = Integer.parseInt(line[0]);
			int d1 = Integer.parseInt(line[1]);
			int n2 = Integer.parseInt(line[2]);
			int d2 = Integer.parseInt(line[3]);
			
			n1 *= d2;
			n2 *= d1;
			
			int num = n1+n2;
			int den = d1*d2;
			int g = gcd(num, den);
			
			num /= g;
			den /= g;
			
			if(den == 1)
				System.out.println(num);
			else if(num == 0)
				System.out.println(9);
			else
				System.out.println(num + " " + den);
		}
	}
}
import java.util.*;
import java.io.*;
import java.math.*;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger fact = new BigInteger("1");
		for(int i = 2; i <= n; i++)
			fact = fact.multiply(BigInteger.valueOf(i));
		
		System.out.println(fact.toString().length() - fact.toString().replaceAll("0", "").length());
	}
}
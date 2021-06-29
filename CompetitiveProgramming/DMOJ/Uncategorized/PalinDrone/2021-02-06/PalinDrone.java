import java.util.*;
import java.io.*;
import java.math.*;

public class PalinDrone
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger n = new BigInteger(br.readLine());
		BigInteger two = n.divide(new BigInteger("2"));
		BigInteger one = n.subtract(two);
		
		BigInteger total = new BigInteger("0");
		if(one.compareTo(new BigInteger("1")) >= 0)
			total = total.add(new BigInteger("9"));
		if(two.compareTo(new BigInteger("1")) >= 0)
			total = total.add(new BigInteger("9"));
		if(one.compareTo(new BigInteger("2")) >= 0)
			total = total.add(new BigInteger("90"));
		if(two.compareTo(new BigInteger("2")) >= 0)
			total = total.add(new BigInteger("90"));
		if(one.compareTo(new BigInteger("3")) >= 0)
			total = total.add((new BigInteger("900")).multiply(one.subtract(new BigInteger("2"))));
		if(two.compareTo(new BigInteger("3")) >= 0)
			total = total.add((new BigInteger("900")).multiply(two.subtract(new BigInteger("2"))));
			
		System.out.println(total.remainder(new BigInteger("1000000000")));
	}
}
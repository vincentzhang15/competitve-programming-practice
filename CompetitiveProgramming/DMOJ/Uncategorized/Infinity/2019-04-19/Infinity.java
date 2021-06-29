import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Infinity
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		
		BigInteger a = new BigInteger(first, 16);
		BigInteger b = new BigInteger(second, 16);
		if((a.add(b)).compareTo(new BigInteger("1061109567")) == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
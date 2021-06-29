import java.io.*;
import java.math.BigInteger;

public class SixteenBitSWOnly
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String [] line = br.readLine().split(" ");
			BigInteger a = new BigInteger(line[0]);
			BigInteger b = new BigInteger(line[1]);
			BigInteger c = new BigInteger(line[2]);
			
			BigInteger product = a.multiply(b);
			if(product.equals(c))
				System.out.println("POSSIBLE DOUBLE SIGMA");
			else
				System.out.println("16 BIT S/W ONLY");
		}
	}
}
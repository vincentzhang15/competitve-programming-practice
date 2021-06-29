import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigDecimal;

public class Tilt
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		BigDecimal sum = new BigDecimal("0");
		for(int i = 0; i < n; i++)
		{
			Double t = Double.parseDouble(br.readLine());
			sum = sum.add(BigDecimal.valueOf(t));
		}
		System.out.println(sum.remainder(new BigDecimal("360")));
	}
}
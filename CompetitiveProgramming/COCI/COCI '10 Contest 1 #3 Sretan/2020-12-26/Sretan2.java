import java.util.*;
import java.io.*;

public class Sretan2
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()) + 1;
		
		String s = "";
		for(; n > 1; n >>= 1)
		{
			if((n & 1) == 1)
				s = "7" + s;
			else
				s = "4" + s;
		}
		System.out.println(s);
	}
}
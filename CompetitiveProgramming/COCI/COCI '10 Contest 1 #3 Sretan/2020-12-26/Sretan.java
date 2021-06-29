import java.util.*;

public class Sretan
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n++;
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
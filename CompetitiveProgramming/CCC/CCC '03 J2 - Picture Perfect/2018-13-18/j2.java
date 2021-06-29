import java.util.*;

public class j2
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		int t = -1;
		
		ArrayList numbers = new ArrayList();
		while(true)
		{
			t = sc.nextInt();
			if(t == 0)
				return;
			
			int l = (int)Math.round(Math.sqrt (t));
			while(true)
			{
				if(t % l == 0)
					break;
				l -= 1;
			}
			int w = t / l;
			System.out.println("Minimum perimeter is "+ 2 * l + 2 * w + " with dimensions " + l + " X " + w);
		}
	}
}
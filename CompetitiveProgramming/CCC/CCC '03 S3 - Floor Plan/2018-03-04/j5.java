import java.util.*;

public class j5
{
	public static void main (String [] args)
	{
		Scanner in = new Scanner (System.in);
		int flooring = in.nextInt();
		int row = in.nextInt();
		int col = in.nextInt();
		
		String [] rowarr = new String [row];
		for(int i = 0; i < row; i++)
		{
			rowarr[i] = in.next();
		}
		for(int i = 0; i < row; i++)
		{
			System.out.println(rowarr[i]);
		}
		for(int i = 0; i < rowarr.length; i++)
		{
			for(int j = 0; j < rowarr[i].length(); j++)
			{
				if(rowarr[i].charAt(j) == 'I')
				{
					if(rowarr[i].charAt(j+1) == '.')
					{
					}
				}
			}
		}
	}
}
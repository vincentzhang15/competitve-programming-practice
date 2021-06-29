import java.util.*;

public class j2new
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int lower = s.nextInt();
		int upper = s.nextInt();

		int count = 0;
		for(int i = lower; i <= upper; i++)
		{
			String check = Integer.toString(i);
			boolean findfalse = false;
			for(int j = 0; j < (check.length()+1)/2; j++)
			{
				int k = check.length() - 1 - j;
				char c1 = check.charAt(j);
				char c2 = check.charAt(k);
				boolean looksame = false;
				if(c1 == '1' && c2 == '1')
					looksame = true;
				else if(c1 == '0' && c2 == '0')
					looksame = true;
				else if(c1 == '8' && c2 == '8')
					looksame = true;
				else if(c1 == '6' && c2 == '9')
					looksame = true;
				else if(c1 == '9' && c2 == '6')
					looksame = true;
				if(!looksame)
				{
					findfalse = true;
					break;
				}
			}
			if(!findfalse)
			{
				count ++;
				System.out.println(i);
			}
		}
		System.out.println(count);
	}
}
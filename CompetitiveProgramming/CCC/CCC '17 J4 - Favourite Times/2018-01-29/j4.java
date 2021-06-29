import java.util.*;

public class j4
{
	public static void main (String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int move = scanner.nextInt();
		int count = 0;
		
		while(move > 720)
		{
			move = move - 720;
			count += 32;
		}
		int endtime = 720 + move;

		
		int h1 = 0;
		int h2 = 0;
		int m1 = 0;
		int m2 = 0;
		for(int i = 720; i <= endtime; i++)
		{
			if(i >= 780)
			{
				h1 = (i - 720) / 60 / 10;
				h2 = (i - 720) / 60 % 10;
				m1 = (i - 720) % 60 / 10;
				m2 = (i - 720) % 60 % 10;
				
				if (i <= 1320)
				{
					if(m2 - m1 == m1 - h2)
						count++;
				}
				else
				{
					if(m2 - m1 == m1 - h2 && m1 - h2 == h2 - h1)
				count++;
				}
			}
			else//12 - 1
			{
				h1 = i / 60 / 10;
				h2 = i / 60 % 10;
				m1 = i % 60 / 10;
				m2 = i % 60 % 10;
					
				if(m2 - m1 == m1 - h2 && m1 - h2 == h2 - h1)
					count++;
			}
		}
		

		System.out.println(count);
	}
}
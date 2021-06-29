import java.util.Scanner;

public class Main
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int minutes = s.nextInt();
		
		int d1 = 1;
		int d2 = 2;
		int d3 = 0;
		int d4 = 0;
		
		int total = 0;
		if(minutes >= 720)
		{
			total = (minutes / 720) * 31;
			minutes = minutes % 720;
		}
		
		for(int i = 1; i <= minutes; i++)
		{
			d4++;
			if(i % 10 == 0)
			{
				d3++;
				d4 = 0;
			}

			if(i % 60 == 0)
			{
				if(d1 == 1 && d2 == 2)
				{
					d1 = 0;
					d2 = 1;
				}
				else if(d2 == 9)
				{
					d1 = 1;
					d2 = 0;
				}
				else
					d2++;
				d3 = 0;
				d4 = 0;
			}

			//System.out.println(d1 + "" + d2 + ":" + d3 + "" + d4);
			if(i >= 60 && i < 600)
			{
				if(d4 - d3 == d3 - d2)
				{
					//System.out.println(d1 + "" + d2 + ":" + d3 + "" + d4);
					total++;
				}
			}
			else
			{
				if(d4 - d3 == d3 - d2 && d3 - d2 == d2 - d1)
				{
					//System.out.println(d1 + "" + d2 + ":" + d3 + "" + d4);
					total++;
				}
			}
		}
		System.out.println(total);
	}
}
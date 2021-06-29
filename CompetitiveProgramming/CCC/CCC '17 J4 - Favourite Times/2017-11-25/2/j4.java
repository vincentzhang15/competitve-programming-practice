import java.util.Scanner;

public class j4
{
	static int calculate(int left)
	{
		int count = 0;
		
		for(int i = 0; i<= left ; i++)
		{
			int hour = i / 60;
			if(hour == 0)
				hour = 12;
			
			int minute = i % 60;
			
			int mhigh = minute / 10;
			int mlow  = minute % 10;
			
			if(hour < 10)
			{
				if( mlow - mhigh == mhigh - hour)
					count ++;
			}
			else if(hour >= 10)
			{
				int hhigh = 1;
				int hlow = hour - 10;
				
				//System.out.println(" hour > 10  " +i + ", " + hhigh + ", " + hlow + ", " + mhigh + ", " + mlow);
				
				if( mlow - mhigh == mhigh - hlow && mlow - mhigh == hlow - hhigh)
				{
					//System.out.println(" --------------------");
					count ++;
				}
			}
		}
		return count;
	}
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int inputvalue = in.nextInt();
		
		
		int halfdays = inputvalue / (60 * 12);
		int left = inputvalue % (60 * 12);
		int count = calculate(left);
		if(halfdays > 0)
		{
			int halfdaycount = calculate(60 * 12);
			count += halfdaycount * halfdays;
		}
		System.out.println(count);
	}
}


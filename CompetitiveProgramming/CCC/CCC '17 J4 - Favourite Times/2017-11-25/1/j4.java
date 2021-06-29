import java.util.Scanner;

public class j4
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		double inputvalue = in.nextDouble();
		
		int count = 0;
		int counthour = 0;
		
		int lefthour = 1;
		int righthour = 2;
		int leftminute = 3;
		int rightminute = 4;
		
		double timeinhour = inputvalue / 60;
		int hour = (int) timeinhour;
		double minutesinhour = timeinhour - hour;
		double minuteswithdecimal = Math.round(minutesinhour * 60);
		int minutes = (int) minuteswithdecimal;

		if(hour == 0)
			hour += 12;
		else if(hour > 12)
		{
			
		}
		int endtime = hour * 100 + minutes;

		System.out.println(timeinhour);
		System.out.println(hour);
		System.out.println(minutes);
		
		for(int i = 1200; i <= endtime; i++)
		{
			if(i % 100 == 60)
			{
				i += 40;
				counthour += 1;
			}
			
			rightminute = i % 10;
			leftminute = (i % 100) - rightminute;
			rightminute = (i % 1000) - (leftminute * 10) - rightminute;
			lefthour = (counthour);
	
			if (rightminute - leftminute == leftminute - righthour && leftminute - righthour == righthour - lefthour)
				count += 1;
		}
		System.out.println(count);
	}
}


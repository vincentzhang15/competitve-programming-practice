import java.util.*;

public class j4
{
	static void print(int endTime)
	{
		if(endTime / 60 < 10)
			System.out.print(0);
		System.out.print(endTime / 60 + ":" + endTime % 60);
		if(endTime % 60 == 0)
			System.out.print(0);
		System.out.println();
	}

	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		String time = s.nextLine();
		
		int hour = Integer.parseInt(time.charAt(0) + "" + time.charAt(1));
		int minute = Integer.parseInt(time.charAt(3) + "" + time.charAt(4));
		int startTime = hour * 60 + minute;
		int endTime = startTime;

		for(int i = 1; i <= 120; i++)
		{
			if(endTime == 1439)
				endTime -= 1440;
			if(endTime >= 420 && endTime < 600 || endTime >= 900 && endTime < 1140)
				endTime ++;
			endTime ++;
		}
		print(endTime);
	}
}
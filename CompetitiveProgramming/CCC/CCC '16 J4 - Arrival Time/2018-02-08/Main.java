//13:53
import java.util.Scanner;

public class Main
{
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		String leave = scanner.next();
		
		int hour = (leave.charAt(0)-'0')*10 + leave.charAt(1)-'0';
		int minute = (leave.charAt(3)-'0')*10 + leave.charAt(4)-'0';
		int t0 = hour * 60 + minute;
		int h = 60;

		int result = 0;
		if(t0 + 2*h <= 7*h)
		{
			result = t0 + 2*h;
		}
		else if(t0 < 7*h)
		{
			int dt = 7*h - t0;
			int left = 2*h - dt;
			if(left * 2 < 3*h)
				result = t0 + dt + left * 2;
			else
				result = t0 + dt + 3*h + (2*h - dt - 90);
		}
		else if(t0 < 10*h)
		{
			int left = 2*h - (10*h - t0)/2;
			result = 10*h + left;
		}
		else if(t0 + 2*h <= 15*h)
		{
			result = t0 + 2*h;
		}
		else if(t0 < 15*h)
		{
			int dt = 15*h - t0;
			int left = 2*h - dt;
			result = t0 + dt + left * 2;
		}
		else if(t0 < 19*h)
		{
			int left = 2*h - (19*h - t0)/2;
			result = 19*h + left;
		}
		else
		{
			result = t0 + 2 * h;
		}
		
		if(result >= 24*h)
			result -= 24*h;
		
		int h1 = result / h;
		int m1 = result %h;
		
		
		System.out.println("" + h1/10 + "" + h1%10 + ":" + m1/10 + "" + m1 % 10);
		
		//7-10
		//15-19
	}
	public static void main(String [] args)
	{
		Main obj = new Main();
		obj.run();
	}
}
//14:
//13:53
import java.util.Scanner;

public class j4
{
	void calculate(int time)
	{
		int hour = time / 60;
		int minute = time % 60;
		
		if(hour < 10)
		{
			if(minute == 0)
			{
System.out.println("...a");
				System.out.println("0" + hour + ":" + minute + "0");
			}
			else
			{
System.out.println("...b");
				System.out.println("0" + hour + ":" + minute);
			}
		}
		else if(hour > 23 && minute > 0)
		{
System.out.println("...c");
			hour -= 24;
		}
		else
		{
			if(minute == 0)
System.out.println("...d");
				System.out.println(hour + ":" + minute + "0");
		}
	}
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		String leave = scanner.next();

		String h = leave.charAt(0) + "" + leave.charAt(1);
		String m = leave.charAt(3) + "" + leave.charAt(4);

		int hour = Integer.parseInt(h + "");
		int minute = Integer.parseInt(m + "");
		int time = hour * 60 + minute;
		
		int rushhour1;
		int rushhour1o;
		int over1;

		int rushtime1;
		int rushtime2;

		int rushhour2;
		int rushhour2o;
		int over2;
		int over_a;
		int time1;
		int time2;
		int time_a;
		System.out.println(hour + "    :   " + minute);		

		if(time >= 420 && time < 600)//start between 7 and 10
		{
			if(time + 120 <= 600)
			{
System.out.println("...-1");
				time1 = time + 240;
				calculate(time1);
			}
			else if(time + 120 > 600)
			{
System.out.println("...0");
				time_a = time + 120;
				over_a = time_a - 600;
				time2 = time + ((600 - time) * 2) + over_a;
				calculate(time2);
System.out.println(time2);
System.out.println(over_a);
System.out.println(time_a);
System.out.println(time - (120 - over_a));
System.out.println((120 - over_a) * 2);
			}
			else
			{
System.out.println("...1");
			rushtime1 = time + ((time - 420) * 2);
			calculate(rushtime1);
			}
		}
		else if(time >= 900 && time < 1140)//start between 3 and 7
		{
			rushtime2 = time + ((1140 - time) * 2);
			calculate(rushtime2);
System.out.println("...2");
		}
/*		else if(time + 120 > 420)//end greater than 7
		{
			if(time + 120 <= 600)//eng less than 10
			{
				time += 120;
				rushhour1 = (time - (time - 420)) + ((time - 420) * 2);
				calculate(rushhour1);
System.out.println("...3");
			}
			else if(time + 120 > 600)//end greater than 10
			{
				time += 120;
				over1 = time - 600;
				rushhour1o = (time - (time - (420 + over1))) + ((time - (420 + over1)) * 2) + over1;
				calculate(rushhour1o);
System.out.println("...4");
			}
		}*/
/*		else if(time + 120 > 900)
		{
			if(time + 120 <= 1140)//end between 3 and 7
			{
				time += 120;
				rushhour2 = (time - (time - 900)) + ((time - 900) * 2);
				calculate(rushhour2);
System.out.println("...5");
			}
			else if(time + 120 > 600)//
			{
				time += 120;
				over2 = time - 1140;
				rushhour2o = (time - (time - (900 + over2))) + ((time - (900 + over2)) * 2) + over2;
				calculate(rushhour2o);
System.out.println("...6");
			}
		}
*/
		else
		{
			time += 120;
			calculate(time);
System.out.println("...7");
		}
	}
	public static void main(String [] args)
	{
		j4 obj = new j4();
		obj.run();
	}
}
//14:
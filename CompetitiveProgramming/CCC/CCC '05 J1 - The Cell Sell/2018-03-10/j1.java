import java.util.*;

public class j1
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		double morningA = sc.nextDouble();
		double eveningA = sc.nextDouble();
		double weekendA = sc.nextDouble();

		double morningB = morningA;
		double eveningB = eveningA;
		double weekendB = weekendA;
		
		if(morningA > 100)
		{
			morningA -= 100;
			morningA *= 25;
		}
		else
			morningA = 0;
		
		if(morningB > 250)
		{
			morningB -= 250;
			morningB *= 45;
		}
		else
			morningB = 0;
		
		eveningA *= 15;
		eveningB *= 35;
		
		weekendA *= 20;
		weekendB *= 25;
		
		System.out.println("Plan A costs " + (morningA + eveningA + weekendA) / 100);
		System.out.println("Plan B costs " + (morningB + eveningB + weekendB) / 100);
		
		if((morningA + eveningA + weekendA) > (morningB + eveningB + weekendB))
			System.out.println("Plan B is the cheapest.");
		else if((morningA + eveningA + weekendA) < (morningB + eveningB + weekendB))
			System.out.println("Plan A is the cheapest.");
		else
			System.out.println("Plan A and B are the same price.");
	}
}
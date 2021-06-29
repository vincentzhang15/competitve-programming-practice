import java.util.*;

public class j3
{
	public static void main (String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();

		int fuel = scanner.nextInt();
			
		int leftfuel = fuel - Math.abs(x1 - x) - Math.abs(y1 - y);
		
		if(leftfuel % 2 == 0)
			System.out.println("Y");
		else if(fuel < leftfuel)
			System.out.println("N");
		else
			System.out.println("N");
	}
}
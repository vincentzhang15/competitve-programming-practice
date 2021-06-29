import java.util.Scanner;

public class Main
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int x1 = s.nextInt();
		int y1 = s.nextInt();
		int x2 = s.nextInt();
		int y2 = s.nextInt();
		int f = s.nextInt();
		
		int distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
		if(f < distance)
			System.out.println("N");
		else if(f % 2 == 0 && distance % 2 == 0)
			System.out.println("Y");
		else if(f % 2 != 0 && distance % 2 != 0)
			System.out.println("Y");
		else
			System.out.println("N");
	}
}
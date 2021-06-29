import java.util.Scanner;

public class j22
{
	static int calculateSteps(int a, int b, int s)
	{
		int sectionN = s / (a + b);
		int remainN = s % (a + b);
		int nikky = sectionN * (a-b);
		if(remainN > a)
			nikky += a - (remainN-a);
		else
			nikky += remainN;
		return nikky;
	}
	
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int s = sc.nextInt();
		
		int nikky = calculateSteps(a,b,s);
		int byron = calculateSteps(c,d,s);

		if(nikky < byron)
			System.out.println("Byron");
		else if(nikky > byron)
			System.out.println("Nikky");
		else
			System.out.println("Tied");
	}
}
//8:36
//8:38
//51
import java.util.Scanner;
public class j1
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the speed limit: ");
		int speedlimit = scanner.nextInt();
		System.out.println("Enter the recorded speed of the car: ");
		int carspeed = scanner.nextInt();
		int dif = carspeed - speedlimit;	
		
		if(dif <= 0)
			System.out.println("Congratulations, you are within the speed limit!");
		else
		{
			if(dif >= 1 && dif <= 20)
			{
				System.out.println("You are speeding and your fine is $100.");
			}
			else if(dif >= 21 && dif <= 30)
			{
				System.out.println("You are speeding and your fine is $270.");
			}
			else
			{
				System.out.println("You are speeding and your fine is $500.");
			}
		}
	}
}
//9:05
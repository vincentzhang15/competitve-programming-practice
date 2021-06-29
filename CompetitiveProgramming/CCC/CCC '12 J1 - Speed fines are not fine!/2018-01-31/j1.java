import java.util.Scanner;

public class j1
{
	public static void main (String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the speed limit: ");
		int limit = scanner.nextInt();
		System.out.println("Enter the recorded speed of the car: ");
		int speed = scanner.nextInt();
		
		if(speed <= limit)
			System.out.println("Congratulations, you are within the speed limit!");
		else if(speed > limit && speed <= limit + 20)
			System.out.println("You are speeding and your fine is $100.");
		else if(speed > limit + 20 && speed <= limit + 30)
			System.out.println("You are speeding and your fine is $270.");
		else
			System.out.println("You are speeding and your fine is $500.");
	}
}
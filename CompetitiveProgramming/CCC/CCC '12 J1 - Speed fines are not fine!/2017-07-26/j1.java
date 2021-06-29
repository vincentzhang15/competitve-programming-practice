import java.util.Scanner;
public class j1 
{
	
    public static void main( String[] args ) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the speed limit: ");
		int speed_limit = reader.nextInt();
		System.out.print("Enter the recorded speed of the car: ");
		int car_speed = reader.nextInt();
		int difference = car_speed - car_speed;
		if (car_speed <= speed_limit)
		{
			System.out.print("Congratulations, you are within the speed limit!");
		}
		else
		{
			System.out.print("DIFFERENCE = "+difference);
			System.out.print("You are speeding and your fine is $");
			if(difference >= 1 & difference <= 20)
			{
				System.out.print("100");
			}
			else if (differences <= 30)
			{
				System.out.print("270");
			}
			else
			{
				System.out.print("500");
			}
		}	
    }
}
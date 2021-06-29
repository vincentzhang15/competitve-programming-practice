import java.util.Scanner;

public class j1
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter weight: ");
		double weight = sc.nextDouble();
		System.out.println("Enter height:");
		double height = sc.nextDouble();
		
		double bmi = weight / (height * height);
		
		if(bmi > 25)
			System.out.println("Overweight");
		else if(bmi >= 18.5 && bmi <= 25.0)
			System.out.println("Normal weight");
		else if(bmi < 18.5)
			System.out.println("Underweight");
	}
}
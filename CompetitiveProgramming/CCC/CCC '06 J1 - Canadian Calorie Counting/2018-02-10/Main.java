import java.util.Scanner;
public class Main
{
	public static void main(String [] args)
	{
		int calories = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a burger choice: ");
		int burger = sc.nextInt();
		switch(burger)
		{
			case 1: calories += 461; break;
			case 2: calories += 431; break;
			case 3: calories += 420; break;
		}
		System.out.println("Please enter a side order choice: ");
		int sorder = sc.nextInt();
		switch(sorder)
		{
			case 1: calories += 100; break;
			case 2: calories += 57; break;
			case 3: calories += 70; break;
		}
		System.out.println("Please enter a drink choice: ");
		int drink = sc.nextInt();
		switch(drink)
		{
			case 1: calories += 130; break;
			case 2: calories += 160; break;
			case 3: calories += 118; break;
		}
		System.out.println("Please enter a dessert choice: ");
		int dessert = sc.nextInt();
		switch(dessert)
		{
			case 1: calories += 167; break;
			case 2: calories += 266; break;
			case 3: calories += 75; break;
		}
		
		System.out.println("Your total Calorie count is " + calories + ".");
	}
}

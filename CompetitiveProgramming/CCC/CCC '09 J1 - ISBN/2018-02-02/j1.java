import java.util.Scanner;

public class j1
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Digit 11?");
		int a = sc.nextInt();
		System.out.println("Digit 12?");
		int b = sc.nextInt();
		System.out.println("Digit 13?");
		int c = sc.nextInt();
		
		int sum = 91;
		
		b *= 3;
		
		sum = sum + a + b + c;
		System.out.println("The 1-3-sum is " + sum);
	}
}
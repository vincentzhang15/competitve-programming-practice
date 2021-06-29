import java.util.*;
public class j4
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int numerator = sc.nextInt();
		int denominator = sc.nextInt();

		int larger;
		if(numerator > denominator)
			larger = numerator;
		else
			larger = denominator;
		for(int i = 1; i <= larger; i++)
		{
			if(numerator % i == 0 && denominator % i == 0)
			{
				numerator = numerator / i;
				denominator = denominator / i;
			}
		}
		if(denominator == 1)
		{
			System.out.println(numerator);
			return;
		}
		if(numerator > denominator)
		{
			System.out.println(numerator / denominator + " " + numerator % denominator + "/" + denominator);
			return;
		}
		else
		{
			System.out.println(numerator + "/" + denominator);
			return;
		}
	}
}
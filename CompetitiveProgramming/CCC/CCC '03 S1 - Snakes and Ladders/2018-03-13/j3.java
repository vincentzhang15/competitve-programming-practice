import java.util.*;

public class j3
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		
		int dice = 1;
		while(true)
		{
			System.out.println("Enter sum of dice: ");
			int sum = sc.nextInt();
			if(sum == 0)
			{
				System.out.println("You Quit!");
				return;
			}
			dice += sum;
			if(dice > 100)
				dice -= sum;

			switch(dice)
			{
				case 9: dice += 25; break;
				case 40: dice += 24; break;
				case 67: dice += 19; break;
				case 54: dice -= 35; break;
				case 90: dice -= 42; break;
				case 99: dice -= 22; break;
				case 100: System.out.println("You Win!"); return;
			}
			System.out.println("You are now on square " + dice);
		}
	}
}
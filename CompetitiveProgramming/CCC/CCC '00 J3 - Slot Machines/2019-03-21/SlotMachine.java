import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SlotMachine
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int coins = Integer.parseInt(br.readLine());
		int one = Integer.parseInt(br.readLine());
		int two = Integer.parseInt(br.readLine());
		int three = Integer.parseInt(br.readLine());
		
		int counter = 0;
		int count = 0;
		while(coins > 0)
		{
			if(counter == 3)
				counter = 0;
			counter++;
			
			if(counter == 1)
			{
				one++;
				if(one == 35)
				{
					coins += 30;
					one = 0;
				}
			}
			else if(counter == 2)
			{
				two++;
				if(two == 100)
				{
					coins += 60;
					two = 0;
				}
			}
			else if (counter == 3)
			{
				three++;
				if(three == 10)
				{
					coins += 9;
					three = 0;
				}
			}
			coins--;
			count++;
			//System.out.println("A:" + one + "\tB:" + two + "\tC:" + three + "\tCOINS:" + coins);
		}
		System.out.println("Martha plays " + count + " times before going broke.");
	}
}
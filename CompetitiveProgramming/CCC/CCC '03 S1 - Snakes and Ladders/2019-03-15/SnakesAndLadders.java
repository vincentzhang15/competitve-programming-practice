import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SnakesAndLadders
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int square = 1;
		int input;
	
		while(true)
		{
			input = Integer.parseInt(br.readLine());
			if(input == 0)
			{
				System.out.println("You Quit!");
				return;
			}
			square += input;
			
			switch(square)
			{
				case 9: square = 34; break;
				case 40: square = 64; break;
				case 67: square = 86; break;
				case 54: square = 19; break;
				case 90: square = 48; break;
				case 99: square = 77; break;
			}
			if(square > 100)
				square -= input;

			System.out.println("You are now on square " + square);
			if(square == 100)
			{
				System.out.println("You Win!");
				return;
			}
		}
	}
}
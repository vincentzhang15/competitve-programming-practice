import java.util.Scanner;
public class Main
{
	int checklast(char letter)
	{
		int lastnum = 0;
		if(letter == 'a' || letter == 'b' || letter == 'c')
			lastnum = 2;	
		else if(letter == 'd' || letter == 'e' || letter == 'f')
			lastnum = 3;                       
		else if(letter == 'g' || letter == 'h' || letter == 'i')
			lastnum = 4;                       
		else if(letter == 'j' || letter == 'k' || letter == 'l')
			lastnum = 5;                       
		else if(letter == 'm' || letter == 'n' || letter == 'o')
			lastnum = 6;                       
		else if(letter == 'p' || letter == 'q' || letter == 'r' || letter == 's')
			lastnum = 7;                       
		else if(letter == 't' || letter == 'u' || letter == 'v')
			lastnum = 8;
		else if(letter == 'w' || letter == 'x' || letter == 'y' || letter == 'z')
			lastnum = 9;
		return lastnum;
	}
	void run()
	{
		Scanner sc = new Scanner(System.in);

		String text = "";
		int times = 0;
		while(true)
		{
			text = sc.next();
			int sum = 0;
			int lastnum = 0;
			times = 0;
			for(int i = 0; i < text.length(); i++)
			{
				char letter = text.charAt(i);

				if(lastnum == checklast(letter))
					times += 2;
				lastnum = checklast(letter);

				if(letter == 'a' || letter == 'd' || letter == 'g' || letter == 'j' 
				|| letter == 'm' || letter == 'p' || letter == 't' || letter == 'w')
					times += 1;
				else if(letter == 'b' || letter == 'e' || letter == 'h' || letter == 'k' 
					 || letter == 'n' || letter == 'q' || letter == 'u' || letter == 'x')
					 times += 2;
				else if(letter == 'c' || letter == 'f' || letter == 'i' || letter == 'l' 
					 || letter == 'o' || letter == 'r' || letter == 'v' || letter == 'y')
					 times += 3;
				else if(letter == 's' || letter == 'z')
					 times += 4;
			}
			if(text.equals("halt"))
				return;

			System.out.println(times);
		}
	}
	public static void main(String [] args)
	{
		Main obj = new Main();
		obj.run();
	}	
}

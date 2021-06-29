import java.util.Scanner;

public class Main
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner (System.in);
		String in = s.next();
		String test = "pusheen";
		
		int count = 0;
		for(int i = 0; i < in.length(); i++)
		{
			if(in.charAt(i) != test.charAt(i))
				count++;
		}
		System.out.println(count);
	}
}
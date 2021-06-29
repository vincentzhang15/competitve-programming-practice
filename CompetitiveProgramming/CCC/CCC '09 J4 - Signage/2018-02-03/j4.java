import java.util.Scanner;
import java.util.ArrayList;

public class j4
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		
		ArrayList<String> words = new ArrayList<String>();

		words.add("WELCOME");
		words.add(".TO");
		words.add(".CCC");
		words.add(".GOOD");
		words.add(".LUCK");
		words.add(".TODAY");
		
		String line = "";
		int add = 0;
		while(true)
		{
			for(int i = 0; i < 6; i++)
			{
				System.out.println(line);
				if(line.length() + words.get(0).length() <= w)
				{
					line = line + "" + words.get(0);
				}
				add = w - line.length();
			System.out.println(add);
			System.out.println(line.length());
			words.remove(0);
			}

			line = "";
			System.out.println(line);
		}
	}
}
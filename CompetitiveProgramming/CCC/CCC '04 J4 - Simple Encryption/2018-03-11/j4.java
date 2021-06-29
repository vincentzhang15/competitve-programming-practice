import java.util.*;

public class j4
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String WLetter = sc.nextLine();
		String word = sc.nextLine();

		int index = 0;		
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
			{
				int letter = word.charAt(i) + WLetter.charAt(index) - 'A';
				if(letter > 90)
					letter -= 26;
				index++;
				
				if(index >= WLetter.length())
					index = 0;
				char print = (char)letter;
				System.out.print(print);
			}
		}
	}
}
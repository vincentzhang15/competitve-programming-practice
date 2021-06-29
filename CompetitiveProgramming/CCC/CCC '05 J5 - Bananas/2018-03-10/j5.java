import java.util.*;

public class j5
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		String word = "";
		boolean monkey = true;
		while(true)
		{
			word = sc.next();
			if(word.equals("X"))
				return;

			for(int i = 0; i < word.length() - 2; i++)
			{
				System.out.println("................." + word);
				String replace = word.charAt(i) + "" + word.charAt(i + 1) + "" + word.charAt(i + 2);
				if(replace.equals("ANA") || replace.equals("BAS"))
					word = "A" + word.substring(i + 3, word.length());
				System.out.println("::::::::::::::::::." + word);
				if(word.length() >= 3)
				{
				System.out.println(":::::");
					String replace1 = word.charAt(0) + "" + word.charAt(1) + "" + word.charAt(2);
					if(replace1.equals("ANA") || replace1.equals("BAS"))
						word = "A" + word.substring(3, word.length());
				}
				System.out.println("::::::::FINAL:::::." + word);
			}
			if(word.length() == 1)
			{
				monkey = true;
			}

			if(monkey)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}


/*
import java.util.*;

public class j5
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		String word = "";
		while(true)
		{
			word = sc.next();
			if(word.equals("X"))
				return;
			System.out.println(word);

			if(word.charAt(0) == 'A' && word.charAt(word.length() - 1) == 'A')
				System.out.println("YES");
			else if(word.charAt(0) == 'B' && word.charAt(word.length() - 1) == 'S')
			{
				int index = word.length() / 2;
				if(word.charAt(index) == 'A')
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			else
				System.out.println("NO");
		}
	}
}
*/
/*
import java.util.*;

public class j5
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		String word = "";
		boolean monkey = true;
		while(true)
		{
			word = sc.next();
			if(word.equals("X"))
				return;

			for(int i = 0; i < word.length() - 2; i++)
			{
				System.out.println("................." + word);
				String replace = word.charAt(i) + "" + word.charAt(i + 1) + "" + word.charAt(i + 2);
				if(replace.equals("ANA") || replace.equals("BAS"))
				{
					for(int a = 0; a <= word.length(); a++)
					{
						if(a == i || a == i + 1 || a == i + 2)
						{}
						else
						{
							word += "" + word.charAt(a);
						}
						if (word.length() == 1)
							break;
						System.out.println(".");
					}
				}
				System.out.println("::::::::::::::::::." + word);
				System.out.println("::::::::::::::::::." + word.length());
*//*				if(word.length() >= 3)
				{
				System.out.println(":::::");
					String replace1 = word.charAt(0) + "" + word.charAt(1) + "" + word.charAt(2);
				if(replace.equals("ANA") || replace.equals("BAS"))
				{
					for(int a = 0; a < word.length(); a++)
					{
						if(a == i || a == i + 1 || a == i + 2)
						{}
						else
						{
							word += "" + word.charAt(a);
						}
					}
				}
				}
				System.out.println("::::::::FINAL:::::." + word);
*//*			}
			if(word.length() == 1)
			{
				monkey = true;
			}

			if(monkey)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}

*/
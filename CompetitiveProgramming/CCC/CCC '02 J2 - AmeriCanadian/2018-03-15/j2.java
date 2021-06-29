import java.util.*;
public class j2
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter words to be translated:");

		while(true)
		{
			String word = sc.next();
			if(word.equals("quit!"))
				return;
			if(word.length() > 4)
			{
				char transport = word.charAt(word.length() - 3);
				if(transport == 'a' || transport == 'e'
				|| transport == 'i' || transport == 'o'
				|| transport == 'u' || transport == 'y')
				{}
				else
				{
					if(word.charAt(word.length() - 2) == 'o')
					{
						if(word.charAt(word.length() - 1) == 'r')
						{
							for(int i = 0; i < word.length() - 1; i++)
							{
								System.out.print(word.charAt(i));
							}
							System.out.println("ur");
							continue;
						}
					}
				}
			}
			System.out.println(word);
		}

		
	}
}
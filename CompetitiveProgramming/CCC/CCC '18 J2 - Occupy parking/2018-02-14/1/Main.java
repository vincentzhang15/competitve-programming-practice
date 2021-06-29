import java.util.*;

public class Main
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);

		int spaces = sc.nextInt();
		String tempyesterday = sc.next();
		String temptoday = sc.next();

		char [] yesterday = new char [spaces];
		char [] today = new char [spaces];

		for(int i = 0; i < spaces; i++)
			yesterday [i] = tempyesterday.charAt(i);
		for(int i = 0; i < spaces; i++)
			today [i] = temptoday.charAt(i);

		int count = 0;
		for(int i = 0; i < spaces; i++)
		{
			if(yesterday[i] == 'C' && today[i] == 'C')
				count++;
		}
		System.out.println(count);
	}
}
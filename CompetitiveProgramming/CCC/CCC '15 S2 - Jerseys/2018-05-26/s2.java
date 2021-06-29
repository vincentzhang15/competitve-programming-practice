import java.util.*;

public class s2
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int jerseys = s.nextInt();
		int people = s.nextInt();
		int given = 0;
		
		char [] sizes = new char [jerseys];
		for(int i = 0; i < jerseys; i++)
		{
			sizes[i] = s.next().charAt(0);
		}

		for(int i = 0; i < people; i++)
		{
			String line = s.nextLine();
			char letter = line.charAt(0);
			int number = line.charAt(2);
			
			System.out.println(line + " : " + number);
			System.out.println(sizes[number - 1] + " " + letter);
			if(sizes[number - 1] <= letter)
			{
				sizes[number] = 't';
				given++;
			}
		System.out.println(given);
		}
	}
}
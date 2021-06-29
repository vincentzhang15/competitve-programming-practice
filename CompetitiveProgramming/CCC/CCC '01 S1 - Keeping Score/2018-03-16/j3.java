import java.util.*;

public class j3
{
	static int calculatePoints(String suit)
	{
		int points = 0;
		if(suit.length() == 0)
			return 3;
		else if(suit.length() == 1)
			points += 2;
		else if(suit.length() == 2)
			points += 1;

		for(int i = 0; i < suit.length(); i++)
		{
			if(suit.charAt(i) == 'A')
				points += 4;
			else if(suit.charAt(i) == 'K')
				points += 3;
			else if(suit.charAt(i) == 'Q')
				points += 2;
			else if(suit.charAt(i) == 'J')
				points += 1;
		}
		return points;
	}
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		String cards = s.next();
		
		String clubs = "";
		int index = 1;
		for(int i = index;;i++)
		{
			char suit = cards.charAt(i);
			if(suit == 'D')
				break;
			clubs += suit;
			index = i;
		}
		if(clubs == "")
			index ++;
		else
			index += 2;

		String diamonds = "";
		for(int i = index;;i++)
		{
			char suit = cards.charAt(i);
			if(suit == 'H')
				break;
			diamonds += suit;
			index = i;
		}
		if(diamonds == "")
			index ++;
		else
			index += 2;

		String hearts = "";
		for(int i = index;;i++)
		{
			char suit = cards.charAt(i);
			if(suit == 'S')
				break;
			hearts += suit;
			index = i;
		}
		if(hearts == "")
			index ++;
		else
			index += 2;

		String spades = "";
		for(int i = index; i < cards.length(); i++)
		{
			char suit = cards.charAt(i);
			spades += suit;
			index = i;
		}
		System.out.println("Cards Dealt                        Points");
	
		System.out.print("Clubs ");
		for(int i = 0; i < clubs.length(); i++)
			System.out.print(clubs.charAt(i) + " ");
		for(int i = 0; i < 32 - (clubs.length() * 2); i++)
			System.out.print(" ");
		System.out.println(calculatePoints(clubs));
	
		System.out.print("Diamonds ");
		for(int i = 0; i < diamonds.length(); i++)
			System.out.print(diamonds.charAt(i) + " ");
		for(int i = 0; i < 29 - (diamonds.length() * 2); i++)
			System.out.print(" ");
		System.out.println(calculatePoints(diamonds));
	
		System.out.print("Hearts ");
		for(int i = 0; i < hearts.length(); i++)
			System.out.print(hearts.charAt(i) + " ");
		for(int i = 0; i < 31 - (hearts.length() * 2); i++)
			System.out.print(" ");
		System.out.println(calculatePoints(hearts));
	
		System.out.print("Spades ");
		for(int i = 0; i < spades.length(); i++)
			System.out.print(spades.charAt(i) + " ");
		for(int i = 0; i < 31 - (spades.length() * 2); i++)
			System.out.print(" ");
		System.out.println(calculatePoints(spades));

		System.out.println("                               Total " + (calculatePoints(clubs) + calculatePoints(diamonds) + calculatePoints(hearts) + calculatePoints(spades)));
	}
}

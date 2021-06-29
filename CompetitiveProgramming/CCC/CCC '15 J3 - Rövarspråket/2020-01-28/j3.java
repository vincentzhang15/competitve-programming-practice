import java.util.*;
public class j3
{
	String [] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	String [] vowels = {"a", "e", "i", "o", "u"};
	//0,4,8,14,20
	
	String nextvowel(int index)
	{
		int end;
		if(index > 0 && index < 4)
			if(index <= 2)
				end = 0;
			else
				end = 4;
		if(index > 0 && index < 4)
			if(index <= 2)
				end = 0;
			else
				end = 4;
		if(index > 0 && index < 4)
			if(index <= 2)
				end = 0;
			else
				end = 4;
		if(index > 0 && index < 4)
			if(index <= 2)
				end = 0;
			else
				end = 4;
		if(index > 0 && index < 4)
			if(index <= 2)
				end = 0;
			else
				end = 4;
			
/*		TreeSet<Integer> end = new TreeSet<Integer>();
		
		for(int anotherindex = 0; anotherindex < 25; anotherindex++)
		{
			if(Math.abs(index - anotherindex < 0)
			if(Math.abs(index - anotherindex) == 0 || Math.abs(index - anotherindex) == 4 || Math.abs(index - anotherindex) == 8 || Math.abs(index - anotherindex) == 14 || Math.abs(index - anotherindex) == 20)
			{
				end.add(Math.abs(anotherindex));
			}
		}

		int end1 = end.first();
		int end2 = Math.abs(index - end1);
		if(index + end2 > 25)
			end1 -= 25;

		String vowel = alphabet[index + end2];
*/		return vowel;
	}
	String nextconsonant(String letter, int index)
	{
		String consonant = letter;
		return consonant;
	}
	void run()
	{
		Scanner sc = new Scanner(System.in);
		String word = sc.next();

		String [] letters = new String [word.length()];
	
		for(int i = 0; i < word.length(); i++)
		{
			letters[i] = String.valueOf(word.charAt(i));
		}
		for(int i = 0; i < word.length(); i++)
		{
			if(letters[i].equals("a") || letters[i].equals("o") || letters[i].equals("e") || letters[i].equals("i") || letters[i].equals("u"))
				continue;
			else
				letters[i] = letters[i] + nextvowel(i) + nextconsonant(letters[i], i);
		}

		for(int i = 0; i < word.length(); i++)
		{
			System.out.println(letters[i]);
		}
	}
	public static void main (String [] args)
	{
		j3 obj = new j3();
		obj.run();
	}
	
}
import java.util.*;

public class j3
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		char [] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
							'H', 'I', 'J', 'K', 'L', 'M', 'N',
							'O', 'P', 'Q', 'R', 'S', 'T', 'U',
							'V', 'W', 'X', 'Y', 'Z', ' ', '-', '.'};
		int sum = 0;
		for(int i = 0; i < word.length(); i++)
		{
			int start = 1;
			int nextnumber = 0;
			char letter = word.charAt(i);
			for(int j = 0; j < alphabet.length; j++)
			{
				if(letter == alphabet[j])
					nextnumber = j;
				System.out.println("letter: " + letter);
				System.out.println("j: " + j);
				System.out.println("nextnumber: " + nextnumber);
			}
			sum = nextnumber / start + nextnumber % start;
			start = nextnumber;
		}
		System.out.println(sum);
	}
}
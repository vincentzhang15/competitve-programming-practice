import java.util.Scanner;

public class j4
{
	public static void main (String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		String codedword = scanner.next();
		
		char [] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		int [] originalword = new int [codedword.length()];
		int [] shiftvalue = new int [codedword.length()];
		int [] value = new int [codedword.length()];

		int pos = 1;
		for(int i = 0; i < codedword.length(); i++)
		{
			shiftvalue[i] = 3 * pos + k;
			pos++;
		}
		int w = 0;
		for(int i = 0; i < codedword.length(); i++)
		{
			for(int j = 0; j < alphabet.length; j++)
			{
				if(alphabet[j] == codedword.charAt(i))
				{
					value[w] = j;
					w++;
				}
			}
		}
		for(int i = 0; i < codedword.length(); i++)
		{
			originalword[i] = value[i] - shiftvalue[i];
			if(originalword[i] < 0)
				originalword[i] += 26;
		}
		for(int i = 0; i < codedword.length(); i++ )
		{
			int index = originalword[i];
			System.out.print(alphabet[index]);
		}
	}
}
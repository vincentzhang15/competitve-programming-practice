//7:59
import java.util.Scanner;
public class j2
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();

		boolean 
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == 'I' || 
			word.charAt(i) == 'O' || 
			word.charAt(i) == 'S' || 
			word.charAt(i) == 'H' || 
			word.charAt(i) == 'Z' || 
			word.charAt(i) == 'X' || 
			word.charAt(i) == 'N')
			System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
//8:10
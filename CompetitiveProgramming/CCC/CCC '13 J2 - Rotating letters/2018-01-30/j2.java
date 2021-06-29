import java.util.Scanner;

public class j2
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		for(int i = 0; i < word.length(); i++)
		{
			//char a = word.charAt(i);
			/*
			if(a == 'I' || a == 'O' 
			|| a == 'S' || a == 'H' 
			|| a == 'Z' || a == 'X' 
			|| a == 'N')
			{}
			*/
			/*
			if(a == 'I') continue;
			else if(a == 'O') continue;
			else if(a == 'S') continue;
			else if(a == 'H') continue;
			else if(a == 'Z') continue;
			else if(a == 'X') continue;
			else if(a == 'N') continue;
			else
			{
				System.out.println("NO");
				return;
			}
			*/
			switch(word.charAt(i))
			{
				case 'I':
				case 'O':
				case 'S':
				case 'H':
				case 'Z':
				case 'X':
				case 'N':
					break;
				default:
					System.out.println("NO");
					return;
			}
		}
		System.out.println("YES");
	}
}
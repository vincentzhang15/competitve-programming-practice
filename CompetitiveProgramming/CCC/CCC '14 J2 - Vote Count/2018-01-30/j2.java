import java.util.Scanner;

public class j2
{
	public static void main(String [] arg)
	{
		Scanner scanner = new Scanner(System.in);
		int loop = scanner.nextInt();
		
		String votes = scanner.next();
		
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < loop; i++)
		{
			if(votes.charAt(i) == 'A')
				a++;
			else if(votes.charAt(i) == 'B')
				b++;
		}

		if(a > b)
			System.out.println("A");
		else if (b > a)
			System.out.println("B");
		else
			System.out.println("Tie");
	}
}
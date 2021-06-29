import java.util.Scanner;

public class j1
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		for (int i = 0; i < 6; i++)
		{
			String a = scanner.nextLine();
			if(a.equals("W"))
				count += 1;
		}
		if (count == 5 || count == 6)
			System.out.println("1");
		else if (count == 3 || count == 4)
			System.out.println("2");
		else if (count == 1 || count == 2)
			System.out.println("3");	
		else
			System.out.println("-1");		
	}
}


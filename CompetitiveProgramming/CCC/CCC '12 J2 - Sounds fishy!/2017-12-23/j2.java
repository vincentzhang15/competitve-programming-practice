//9:06
//9:08
import java.util.Scanner;
public class j2
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int one = scanner.nextInt();
		int two = scanner.nextInt();
		int three = scanner.nextInt();
		int four = scanner.nextInt();

		if(one < two && two < three && three < four)
			System.out.println("Fish Rising.");
		else if(one > two && two > three && three > four)
			System.out.println("Fish Diving.");
		else if(one == two && two == three && three == four)
			System.out.println(" Fish At Constant Depth.");
		else
			System.out.println("No Fish");
	}
}
//9:14
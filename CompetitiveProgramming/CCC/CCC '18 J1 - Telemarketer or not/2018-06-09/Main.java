import java.util.*;

public class Main
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int one = sc.nextInt();
		int two = sc.nextInt();
		int three = sc.nextInt();
		int four = sc.nextInt();
		
		if(one == 8 || one == 9)
			if(two == three)
				if(four == 8 || four == 9)
				{
					System.out.println("ignore");
					return;
				}
		System.out.println("answer");
	}
}
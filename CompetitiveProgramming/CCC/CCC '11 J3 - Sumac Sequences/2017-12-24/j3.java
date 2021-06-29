import java.util.Scanner;
public class j3
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int one = scanner.nextInt();
		int two = scanner.nextInt();
		
		int three = one - two;
		
		if(three > two)
		{
			System.out.println("3");	
			return;
		}
		
		int i;
		for(i = 4;;i++)
		{
			one = two;
			two = three;
			three = one - two;
//			System.out.println("..." + three);
			if(three > two)
				break;
		}
		System.out.println(i);
	}
}
import java.util.Scanner;

public class j1
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int youngest = sc.nextInt();
		int middle = sc.nextInt();
		
		int oldest = middle + (middle - youngest);
		System.out.println(oldest);
	}
}
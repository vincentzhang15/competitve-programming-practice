import java.util.Scanner;

public class j3
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();

		int i = 0;
		while(t1 >= t2)
		{
			int t3 = t1 - t2;
			t1 = t2;
			t2 = t3;
			i++;
		}
		System.out.println(i + 2);
	}
}
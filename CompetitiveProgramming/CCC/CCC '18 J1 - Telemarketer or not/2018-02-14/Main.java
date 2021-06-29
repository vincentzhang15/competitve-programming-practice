import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int n4 = in.nextInt();
		boolean ignore1 = false;
		boolean ignore2 = false;
		boolean ignore3 = false;
		if(n1==8 || n1==9)
			ignore1 = true;
		if(n4==8 || n4==9)		
			ignore2 = true;
		if(n2==n3)
			ignore3 = true;
		if(ignore1==true && ignore2==true && ignore3==true)
			System.out.println("ignore");
		else
			System.out.println("answer");
		
	}
}
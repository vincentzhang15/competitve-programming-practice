import java.util.Scanner;
import java.util.*;

public class j5
{
	public static void main(String [] args)
	{		
		Scanner in = new Scanner(System.in);
		int piecesofpie = in.nextInt();
		int peopleinline = in.nextInt();

		int[] splitting = new int[peopleinline];
		
		splitting[splitting.length-1] = piecesofpie - peopleinline + 1;
		for(int i = 1; i < peopleinline*5; i++)
		{
			System.out.println("   " + i);
			System.out.println(splitting[splitting.length]-i);
		}
//			System.out.println(splitting[splitting.length-1]);
	}
}


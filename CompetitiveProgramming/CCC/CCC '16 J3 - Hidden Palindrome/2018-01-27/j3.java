//10:54
import java.util.Scanner;
import java.util.ArrayList;

public class j3
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		String original = scanner.next();
		
		String newstr = "";
		String newstr1 = "";

		ArrayList<Integer> listofstr = new ArrayList<Integer>();

		for(int i = 0; i < original.length(); i++)
		{
			newstr = "";
			for(int c = 0; c < original.length(); c++)
			{
				for(int d = 0; d < original.length() - c; d++)
				{
					newstr += original.charAt(i);
					i++;
				}
				newstr1 = "";
				for(int b = original.length() -1 ; b >= 0; b--)
					newstr1 += original.charAt(b);
				
				if(newstr.equals(newstr1))
					listofstr.add(newstr.length());
			}

		}

		System.out.println();
		System.out.println();
		System.out.println(listofstr);
		System.out.println(newstr);
		System.out.println(newstr1);

	}
}
//11:
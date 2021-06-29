import java.util.*;

public class j4
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		String line = s.next();
		String ans = "";
		
		for(int i = 0; i < line.length(); i++)
		{
			int letter = line.charAt(i) - (3*(i+1) + k);
			while(letter < 65)
				letter += 26;
			System.out.print((char)letter);
		}
	}
}
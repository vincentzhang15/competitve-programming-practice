import java.util.*;

public class j4
{
	static String filter (String line)
	{
		for(int i = line.length() - 1; i >= 0; i--)
		{
			if(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u' )
			{
				if(i == 0)
					break;
				if(line.charAt(i-1) == 'a' || line.charAt(i-1) == 'e' || line.charAt(i-1) == 'i' || line.charAt(i-1) == 'o' || line.charAt(i-1) == 'u' )
				{
					String freshline = "";
					for(int j = i -1; j < line.length(); j++)
					{
						char transfer = line.charAt(j);
						String transfer1 = Character.toString(transfer);
						freshline += transfer1;
					}
					return freshline;
				}
				else
				{
					String freshline = "";
					for(int j = i; j < line.length(); j++)
					{
						char transfer = line.charAt(j);
						String transfer1 = Character.toString(transfer);
						freshline += transfer1;
					}
					return freshline;
				}
			}
		}
		return line;
	}
	public static void main (String [] args)
	{
		Scanner in = new Scanner (System.in);
		int verses = in.nextInt();

		Scanner sc = new Scanner (System.in);
		for(int a = 0; a < verses; a++)
		{
			String line1 = sc.nextLine();
			String line2 = sc.nextLine();
			String line3 = sc.nextLine();
			String line4 = sc.nextLine();
		
			line1 = filter(line1);
			line2 = filter(line2);
			line3 = filter(line3);
			line4 = filter(line4);

			if(filter(line1).equals(filter(line2)) && filter(line2).equals(filter(line3)) && filter(line3).equals(filter(line4)))
				System.out.println("perfect");
			else if(filter(line1).equals(filter(line2)) && filter(line3).equals(filter(line4)) && !filter(line2).equals(filter(line3)))
				System.out.println("even");
			else if(line1.equals(line3) && line2.equals(line4) && !filter(line2).equals(filter(line3)))
				System.out.println("cross");
			else if(filter(line1).equals(filter(line4)) && filter(line2).equals(filter(line3)) && !filter(line3).equals(filter(line4)))
				System.out.println("shell");
			else
				System.out.println("free");
		}
	}
}
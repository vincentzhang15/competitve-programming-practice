import java.util.*;

public class j3
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		for(int j = year;; j++)
		{
			switch(year.length())
			{
				case 2: 
				if(year / 10 != year %10)
					System.out.println(j);
					break;
				case 3:
				if(year / 10 != year %10 && year / 100 != year / 10)
					System.out.println(j);
					break;
				case 4:
				if(year.charAt(j) != year.charAt(j + 1) && year.charAt(j + 1) != year.charAt(j + 2)
				&& year.charAt(j + 2) != year.charAt(j + 3) && year.charAt(j + 3) != year.charAt(j))
					System.out.println(j);
					break;
				case 5:
				if(year.charAt(j) != year.charAt(j + 1) && year.charAt(j + 1) != year.charAt(j + 2)
				&& year.charAt(j + 2) != year.charAt(j + 3) && year.charAt(j + 3) != year.charAt(j + 4)
				&& year.charAt(j + 4) != year.charAt(j))
					System.out.println(j);
					break;
				default: 
					System.out.println(j);
/*			
			switch(year.length())
			{
				case 2: 
				if(year.charAt(j) != year.charAt(j + 1))
					System.out.println(j);
					break;
				case 3:
				if(year.charAt(j) != year.charAt(j + 1) && year.charAt(j + 1) != year.charAt(j + 2)
				&& year.charAt(j + 2) != year.charAt(j))
					System.out.println(j);
					break;
				case 4:
				if(year.charAt(j) != year.charAt(j + 1) && year.charAt(j + 1) != year.charAt(j + 2)
				&& year.charAt(j + 2) != year.charAt(j + 3) && year.charAt(j + 3) != year.charAt(j))
					System.out.println(j);
					break;
				case 5:
				if(year.charAt(j) != year.charAt(j + 1) && year.charAt(j + 1) != year.charAt(j + 2)
				&& year.charAt(j + 2) != year.charAt(j + 3) && year.charAt(j + 3) != year.charAt(j + 4)
				&& year.charAt(j + 4) != year.charAt(j))
					System.out.println(j);
					break;
				default: 
					System.out.println(j);
			}
*/
		}
	}
}
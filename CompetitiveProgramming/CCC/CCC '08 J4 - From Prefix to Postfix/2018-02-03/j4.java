import java.util.*;

public class j4
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = "";
		int plus = 0;
		int minus = 0;
		while(!input.equals("0"))
		{
			input = sc.nextLine();
			for(int i = 0; i < input.length(); i++)
			{
				if(input.charAt(i) == '+')
					plus ++;
				else if(input.charAt(i) == '-')
					minus ++;
			}
			if(plus == 0 && minus == 0)
				System.out.println(input);
			else if(plus == 1 && minus == 0 || plus == 0 && minus == 1)
				System.out.println(input.charAt(2) + " " + input.charAt(4) + " " + input.charAt(0));
		}
	}
}
import java.util.*;

public class s1
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int numbers = s.nextInt();
		ArrayList<Integer> money = new ArrayList<Integer>();
		
		for(int i = 0; i < numbers; i++)
		{
			int input = s.nextInt();
			if(input == 0)
				money.remove(money.size()-1);
			else
				money.add(input);
		}
		int sum = 0;
		for(int i = 0; i < money.size(); i++)
		{
			sum += money.get(i);
		}
		System.out.println(sum);
	}
}
import java.util.*;

public class j3
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int quaters = s.nextInt();
		int first = s.nextInt();
		int second = s.nextInt();
		int third = s.nextInt();

		int count = 0;
		while(quaters > 0)
		{
			first ++;
			quaters --;
			count ++;
			if(first % 35 == 0)
				quaters += 30;

			second ++;
			quaters --;
			count ++;
			if(second % 100 == 0)
				quaters += 60;

			third ++;
			quaters --;
			count ++;
			if(third % 10 == 0)
				quaters += 9;
		}
		System.out.println(count);
	}
}
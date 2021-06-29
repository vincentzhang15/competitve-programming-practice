import java.util.*;

public class j5
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int question = s.nextInt();
		int participants = s.nextInt();
		int speed = 0;
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		for(int i = 0; i < participants; i++)
			d.add(s.nextInt());
		for(int i = 0; i < participants; i++)
			p.add(s.nextInt());
		
		if(question == 1)
		{
			Collections.sort(d);
			Collections.sort(p);
		}
		else
		{
			Collections.sort(d);
			Collections.sort(p);
			Collections.reverse(p);
		}

		for(int i = 0; i < participants; i++)
		{
			if(d.get(i) > p.get(i))
				speed += d.get(i);
			else
				speed += p.get(i);
		}		
		System.out.println(speed);
	}
}
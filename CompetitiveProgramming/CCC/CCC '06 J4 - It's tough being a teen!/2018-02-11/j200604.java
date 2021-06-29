import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
	
public class j200604
{
	ArrayList<Integer> before = new ArrayList<Integer>();
	ArrayList<Integer> after = new ArrayList<Integer>();
	ArrayList<Boolean> taken = new ArrayList<Boolean>();
	
	boolean canBeDone (int i)
	{
		if(taken.get(i))
			return false;
		
		boolean neverafter = true;
		for(int j = 1; j<after.size(); j++)
		{
			if (after.get(j) == i)
				neverafter = false;
		}
		
		if ( neverafter )
			return true;
			
		boolean taskbeforedone = true;
		for (int j = 1; j< after.size(); j++)
		{
			if( after.get(j) == i && ! taken.get( before.get(j))) 
				taskbeforedone = false;
		}
		return taskbeforedone;
	}
	
	void run()
	{
		
		before.add(0); after.add(0); taken.add(false);
		
		before.add(1); 	after.add(7);
		before.add(1); 	after.add(4);
		before.add(2); 	after.add(1);
		before.add(3); 	after.add(4);
		before.add(3); 	after.add(5);
		
		Scanner sc = new Scanner(System.in);

		while(true)	
		{
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();

			if(c1 == 0 && c2 == 0)
				break;
			before.add(c1); 	after.add(c2);
		}
			
		for (int j = 1; j<=7; j++)
		{
			taken.add(false);
		}
		
		String result = "";
		for(int k = 1; k<taken.size(); k++)
		{
			boolean didsometask = false;
			for(int i=1; i<=7; i++)
			{
				if (canBeDone(i))
				{
					taken.set(i, true);
					result = result + i + " ";
					didsometask = true;
					break;
				}
			}
			if ( !didsometask )
			{
				System.out.println("Go to bed.");
				return;
			}
		}
		System.out.println(result);
	}
	
	public static void main(String [] args)
	{
		j200604 m = new j200604();
		m.run();
	}	
}

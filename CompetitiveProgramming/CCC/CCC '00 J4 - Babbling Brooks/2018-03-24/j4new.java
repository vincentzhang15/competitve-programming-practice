import java.util.*;

public class j4new
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		ArrayList<Integer> stream = new ArrayList<Integer>();

		for(int i = 0; i < n; i++)
		{
			int data = s.nextInt();
			stream.add(data);
		}
		
		System.out.println("init: " + stream);
		
		
		for(int i = 0;; i++)
		{
			int data = s.nextInt();

			System.out.println("input: " + data);
			
			if(data == 77)
				break;

			if(data == 99)
			{
				int current = s.nextInt()-1;
				int percent = s.nextInt();
				
				double amount = (double)(int)stream.get(current);
				double aleft = amount * percent / 100.0;
				double aright = amount - aleft;
				stream.set(current, (int)aright);
				stream.add(current, (int)aleft);
				System.out.println("split: " + current +", " + percent + ": "+ stream);
			}
			else if(data == 88)
			{
				int current = s.nextInt()-1;
				int aleft = (int)stream.get(current);
				int aright = (int)stream.get(current+1);
				int amount = aleft + aright; 
				stream.set(current, amount);
				stream.remove(current+1);
				System.out.println("merge: " + current + ": "+ stream);
			}
			else
			{
				System.out.println("Error input data !!!");
				break;
			}
		}

		System.out.println(stream);
	}
}
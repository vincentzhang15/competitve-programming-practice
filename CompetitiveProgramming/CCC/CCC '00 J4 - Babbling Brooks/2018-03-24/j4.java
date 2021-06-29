import java.util.*;

public class j4
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		ArrayList<Integer> stream = new ArrayList<Integer>();
		ArrayList<Integer> split = new ArrayList<Integer>();
		ArrayList<Integer> join = new ArrayList<Integer>();

		for(int i = 0; i < n; i++)
			stream.add(i);
		
		for(int i = 0;; i++)
		{
			if(n == 77)
				break;

			int data = s.nextInt();

			if(data == 99)
			{
				int current = s.nextInt();
				int percent = s.nextInt();
				split.add(current * 1000 + percent);
				int left = percent * stream.get(i) / 100;
				int right = stream.get(i) - left;
				int number = stream.get(current + 1);
				number += right;
			}

			if(data == 88)
			{
				int current = s.nextInt();
				int value = current + 1;
				join.add(current);
				int number = stream.get(value);
				number += stream.get(i);
				stream.remove(i);
			}
		}

		System.out.println(stream);
	}
}
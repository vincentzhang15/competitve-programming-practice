import java.util.*;

public class j4
{
	String calculate(String cmd, int move)
	{
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	hm.put(0, -1);
	hm.put(0, -2);
	hm.put(0, -3);
	hm.put(1, -3);
	hm.put(2, -3);
	hm.put(3, -3);
	hm.put(3, -4);
	hm.put(3, -5);
	hm.put(4, -5);
	hm.put(5, -5);
	hm.put(5, -4);
	hm.put(5, -3);
	hm.put(6, -3);
	hm.put(7, -3);
	hm.put(7, -4);
	hm.put(7, -5);
	hm.put(7, -6);
	hm.put(7, -7);
	hm.put(6, -7);
	hm.put(5, -7);
	hm.put(4, -7);
	hm.put(3, -7);
	hm.put(2, -7);
	hm.put(1, -7);
	hm.put(0, -7);
	hm.put(-1, -7);
	hm.put(-1, -6);
	hm.put(-1, -5);

		System.out.println(hm.size());
//		for(int i = 0; i < move; i++)
//		{
			
//		}
/*			
			if(direction.equals("l"))
			{
				left(spaces);
			}
			if(direction.equals("d"))
			{
				down(spaces);
			}
			if(direction.equals("r"))
			{
				right(spaces);
			}
			if(direction.equals("u"))
			{
				up(spaces);
			}
*/
		return "";
	}
	void run()
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0;; i++)
		{
			String direction = sc.next();
			int spaces = sc.nextInt();
			
			if(direction.equals("q") && spaces == 0)
				return;

			System.out.println(calculate(direction, spaces));
		}
	}
	public static void main(String [] args)
	{
		j4 obj = new j4();
		obj.run();
	}
}
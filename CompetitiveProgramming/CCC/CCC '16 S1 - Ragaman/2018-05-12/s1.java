import java.util.*;

public class s1
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		ArrayList<Character> list1 = new ArrayList<Character>();
		ArrayList<Character> list2 = new ArrayList<Character>();

		String line1 = s.next();
		String line2 = s.next();

		for(int i = 0; i < line1.length(); i++)
			list1.add(line1.charAt(i));
		for(int i = 0; i < line2.length(); i++)
			list2.add(line2.charAt(i));
		Collections.sort(list1);
		Collections.sort(list2);
		
		for(int k = 0; k < list1.size() * 2; k++)
		{
			int i,j = 0;
			for(i = 0; i < list1.size(); i++)
			{
				for(j = 0; j < list2.size(); j++)
				{
					if(list1.get(i) == list2.get(j))
					{
						list1.remove(i);
						list2.remove(j);
						break;
					}
				}
			}
		}
		if(list2.size() == 0)
		{
			System.out.println("A");
			return;
		}
		if(list2.get(0) == '*')
			System.out.println("A");
		else
			System.out.println("N");
	}
}
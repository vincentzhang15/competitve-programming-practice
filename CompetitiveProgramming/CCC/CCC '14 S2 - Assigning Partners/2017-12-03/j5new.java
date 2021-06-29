import java.util.*;

public class j5new
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int people = in.nextInt();
		
		boolean count = true;
		
		String [] list0 = new String[people];
		HashMap<String, String> list1 = new HashMap<String, String>(people);
		
		for(int i = 0; i < people; i++)
		{
			list0[i] = in.next();;
		}

		for(int i = 0; i < people; i++)
		{
			String name2 = in.next();
			list1.put(list0[i], name2);
		}

		Set set1 = list1.entrySet();
		Iterator i1 = set1.iterator();
		  
		while (i1.hasNext())
		{
			Map.Entry team = (Map.Entry)i1.next();
			String n1 = team.getName();
			String n2 = team.getValue();
			
			String n3 = list1.get(n2);
			if(n1.equals(n2))
			{
				count = true;
				break;
			}
			if(!n1.equals(n3))
			{
				count = true;
				break;
			}
		}
		
		if(count)
			System.out.println("good");
		else
			System.out.println("bad");
		
	}
}


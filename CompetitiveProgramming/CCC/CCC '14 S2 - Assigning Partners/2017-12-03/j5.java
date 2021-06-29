import java.util.*;

public class j5
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int people = in.nextInt();
		
		boolean count = true;
		
		List<String> firstlist = new ArrayList<String>(people);
		List<String> secondlist = new ArrayList<String>(people);
		
		for(int i = 0; i < people; i++)
		{
			firstlist.add(in.next());
		}

		for(int i = 0; i < people; i++)
		{
			secondlist.add(in.next());
		}

		for(int i =0; i < people; i++)
		{
			if(firstlist.get(i).equals(secondlist.get(i)))
			{
				count = false;
			}
			
			String firstperson = firstlist.get(i);
			String secondperson = secondlist.get(i);
			for(int j = 0; j<people; j++)
			{
				String checkone = secondlist.get(j);
				if(firstperson.equals(checkone))
				{
					String checktwo = firstlist.get(j);
					if(secondperson.equals(checktwo))
					{
					}
					else
						count = false;
				}
					
			}
		}
/*
		for(int i = 0; i < people; i++)
		{
			if(!firstlist.get(i).equals(secondlist.get(i)))
			{
				count = true;
				System.out.println("goes in if");
			}
			else
			{
				System.out.println("goes in else");				
				Collections.sort(firstlist, new Comparator<String>()
				{
					public int compare(String s1, String s2)
					{
						return s1.compareToIgnoreCase(s2);
					}
				});
				
				Collections.sort(secondlist, new Comparator<String>()
				{
					public int compare(String s1, String s2)
					{
						return s1.compareToIgnoreCase(s2);
					}
				});
					
				if(firstlist.get(i).equals(secondlist.get(i)))
					count = false;
			}
		}*/
		if(count)
			System.out.println("good");
		else
			System.out.println("bad");
		
/*		System.out.println();
		System.out.println();
		for(int a = 0; a < people; a++)
		{
			System.out.println(firstlist.get(a));
		}
		System.out.println();
		System.out.println();
		for(int a = 0; a < people; a++)
		{
			System.out.println(secondlist.get(a));
		}	
		System.out.println();
		System.out.println();				
*/
	}
}


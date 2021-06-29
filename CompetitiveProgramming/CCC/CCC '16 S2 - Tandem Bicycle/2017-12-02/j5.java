import java.util.Scanner;
import java.util.*;

public class j5
{
	public static void main(String [] args)
	{		
		Scanner in = new Scanner(System.in);
		int typeofquestion = in.nextInt();

		int numberofparticipants = in.nextInt();

		int[] dspeed = new int[numberofparticipants];
		int[] pspeed = new int[numberofparticipants];

		for(int i = 0; i < numberofparticipants; i++)
		{
			dspeed[i] = in.nextInt();
		}

		for(int j = 0; j < numberofparticipants; j++)
		{
			pspeed[j] = in.nextInt();
		}

		HashMap dmojistanspeeds = new HashMap();
		for(int i = 0; i < numberofparticipants; i++)
		{				
			dmojistanspeeds.put(dspeed[i], 0);
		}
		
		Set set1 = dmojistanspeeds.entrySet();
		Iterator i1 = set1.iterator();
			  
		while (i1.hasNext())
		{
				Map.Entry me1 = (Map.Entry)i1.next();
			    int x = Integer.parseInt(me1.getKey().toString());  ;

				System.out.println();		  
				System.out.print(x + ": ");
		}
			System.out.println();		

		HashMap peglandspeeds = new HashMap();
		for(int i = 0; i < numberofparticipants; i++)
		{				
			peglandspeeds.put(pspeed[i], 0);
		}
		
		Set set2 = peglandspeeds.entrySet();
		Iterator i2 = set2.iterator();
			  
		while (i2.hasNext())
		{
				Map.Entry me2 = (Map.Entry)i2.next();
			    int y = Integer.parseInt(me2.getKey().toString());  ;

				System.out.println();				
				System.out.print(y);
		}
		System.out.println();		
//////////////////////////////////////////////////////////////////////////////////////////		
		if(typeofquestion == 1)
		{
			List<Map.Entry> sorteddspeed = new ArrayList<Map.Entry>(dmojistanspeeds.entrySet());
			Collections.sort(sorteddspeed, new Comparator<Map.Entry>()
			{
				public int compare(Map.Entry o1, Map.Entry o2)
				{
					return Integer.parseInt(o2.getKey().toString()) - Integer.parseInt(o1.getKey().toString());
				}
			});			
			Object[] arrofsortedd = sorteddspeed.toArray();

//////////////////////////////
			List<Map.Entry> sortedpspeed = new ArrayList<Map.Entry>(peglandspeeds.entrySet());
			
			Collections.sort(sortedpspeed, new Comparator<Map.Entry>()
			{
				public int compare(Map.Entry o1, Map.Entry o2)
				{
					return Integer.parseInt(o2.getKey().toString()) - Integer.parseInt(o1.getKey().toString());
				}
			});
			Object[] arrofsortedp = sortedpspeed.toArray();			
///////////////////////////////
			for(int a = 0; a < numberofparticipants; a++)
			{
	//			int total = arrofsortedd[a] + arrofsortedp[a];
//				System.out.println("D country " + arrofsortedd[a]);// + " P country " + arrofsortedp[a]);
			}

		}
		else
		{
			
		}
	}
}
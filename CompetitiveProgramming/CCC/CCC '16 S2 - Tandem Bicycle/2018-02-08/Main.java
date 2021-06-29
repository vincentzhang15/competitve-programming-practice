import java.util.Scanner;
import java.util.*;

public class Main
{
	public static void main(String [] args)
	{		
		Scanner in = new Scanner(System.in);
		int typeofquestion = in.nextInt();

		int numberofparticipants = in.nextInt();

		List<Integer> dspeed = new ArrayList<Integer>(numberofparticipants);
		List<Integer> pspeed = new ArrayList<Integer>(numberofparticipants);
		
		
		for(int i = 0; i < numberofparticipants; i++)
		{
			dspeed.add(in.nextInt());
		}

		for(int j = 0; j < numberofparticipants; j++)
		{
			pspeed.add(in.nextInt());
		}

		
		Collections.sort(dspeed, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		
		if(typeofquestion == 1) // min
		{
			Collections.sort(pspeed, new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
		}
		else // type = 2;
		{
			Collections.sort(pspeed, new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		}	
			
		int total = 0;
		for(int i=0; i< dspeed.size(); i++)
		{
			int ds = dspeed.get(i);
			int ps = pspeed.get(i);
			
			//System.out.println( i + ", " + ds + ", " + ps);
			
			if(ps > ds)
				total += ps;
			else
				total += ds;
		}
		
		System.out.println(total);
	}
}


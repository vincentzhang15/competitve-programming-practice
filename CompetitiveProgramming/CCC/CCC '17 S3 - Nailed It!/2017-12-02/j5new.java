import java.util.Scanner;
import java.util.*;

public class j5new
{
	public static void main(String [] args)
	{		
		Scanner in = new Scanner(System.in);
		int numberOfWoods = in.nextInt();

		int[] lengths = new int[numberOfWoods];

		int[] w = new int[numberOfWoods];
		
		System.out.println(" wood list: ");
		
		HashMap uniqLen = new HashMap();
		
		for(int i = 0; i < numberOfWoods; i++)
		{				
			lengths[i] = in.nextInt();
			//System.out.println(i +  ": " + lengths[i]);
			int count = 1;
			if(uniqLen.containsKey(lengths[i]))
			{
				count = Integer.parseInt(uniqLen.get(lengths[i]).toString()) + 1;
			}
			
			// map { board lenth, number of boards }
			uniqLen.put(lengths[i], new Integer(count));
		}

		{ // debug print 1
			System.out.println(" origin: ");
		  
		   Set set1 = uniqLen.entrySet();
		   Iterator i1 = set1.iterator();
			  
		   while (i1.hasNext()){
				Map.Entry me1 = (Map.Entry)i1.next();
			    int x = Integer.parseInt(me1.getKey().toString());  ;
			    int y = Integer.parseInt(me1.getValue().toString());  ;
		  
				System.out.println(x + ": " + y);
		  }
		  
		  System.out.println();
		
		}

		HashMap hm = new HashMap();
		
		{
		   Set set1 = uniqLen.entrySet();
		   Iterator i1 = set1.iterator();
			  
		   while (i1.hasNext()){
				Map.Entry me1 = (Map.Entry)i1.next();
			    int x = Integer.parseInt(me1.getKey().toString());  ;
				
			   Set set2 = uniqLen.entrySet();
			   Iterator i2 = set2.iterator();
				  
			   while (i2.hasNext()){
					Map.Entry me2 = (Map.Entry)i2.next();
					int y = Integer.parseInt(me2.getKey().toString());  ;
					
					int L = x + y;
					// map { lenth of 2 boards, length of the fence }
					hm.put(new Integer(L), new Integer(0));
			   }
		   }
		}
		
		Set set = hm.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) 
		{
			Map.Entry me = (Map.Entry)it.next();
			int L = Integer.parseInt(me.getKey().toString());
			
			int count = 0;

			Set set1 = uniqLen.entrySet();
			Iterator i1 = set1.iterator();
			  
			while (i1.hasNext())
			{
				Map.Entry me1 = (Map.Entry)i1.next();  
				int x = Integer.parseInt(me1.getKey().toString());
				int n = Integer.parseInt(me1.getValue().toString());
				if(x*2 == L)
				{
					count += n/2;
				}
				else if(x*2 < L)
				{
					if(uniqLen.containsKey(L-x))
					{
						int n2 = Integer.parseInt(uniqLen.get(L-x).toString());
						if(n2 > n)
							count += n;
						else
							count += n2;
					}
				}
			}
				
			me.setValue(count);
		  }
		  
		System.out.println(" combinations: ");
		  
		  it = set.iterator();
		  while(it.hasNext()) {
			 Map.Entry me = (Map.Entry)it.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		  }
		  
		  System.out.println();


		HashMap lenmap = new HashMap();
		
		it = set.iterator();
		while(it.hasNext()) 
		{
			Map.Entry me = (Map.Entry)it.next();
			
			int n = Integer.parseInt(me.getValue().toString());
			int v = 1;
			if(lenmap.containsKey(n))
			{
				v = Integer.parseInt(lenmap.get(n).toString()) + 1;
			}
			lenmap.put(n, new Integer(v));
		}
		
		List<Map.Entry> keys = new ArrayList<Map.Entry>(lenmap.entrySet());
		
		Collections.sort(keys, new Comparator<Map.Entry>() {

			public int compare(Map.Entry o1, Map.Entry o2) {
				return Integer.parseInt(o2.getKey().toString()) - Integer.parseInt(o1.getKey().toString());
			}
		});
		
		
		{
			System.out.println(" results: ");
			Set set3 = lenmap.entrySet();
			
			Iterator it3 = set3.iterator();
			while(it3.hasNext()) {
				Map.Entry me = (Map.Entry)it3.next();
				System.out.print(me.getKey() + ": ");
				System.out.println(me.getValue());
			}
			
		}

			System.out.println(" sorted: ");
			
		for(int i=0; i< keys.size(); i++)
		{
			Map.Entry me = (Map.Entry)keys.get(i);
            System.out.println(me.getKey() + " " + me.getValue());
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("----------------- Answer -----------------");
		System.out.println("");
		System.out.println("");

		{
			int lastkey = 0; //keys.size()-1;
			Map.Entry me = (Map.Entry)keys.get(lastkey);
            System.out.println(me.getKey() + " " + me.getValue());
        }		
		  
	}
		
}


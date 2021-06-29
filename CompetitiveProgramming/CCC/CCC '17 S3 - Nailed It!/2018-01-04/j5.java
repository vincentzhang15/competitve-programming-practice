import java.util.*;

public class j5
{
	public static void main (String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int pieces = scanner.nextInt();
		
		int [] wood = new int [pieces];
		
		HashMap<Integer, Integer> boards = new HashMap<Integer, Integer>();//board length, #ofboards
		
		for(int i = 0; i < pieces; i++)
		{				
			wood[i] = scanner.nextInt();
			int count = 1;
			if(boards.containsKey(wood[i]))
				count = boards.get(wood[i]) + 1;

			boards.put(wood[i], new Integer(count));
		}

		HashMap map1 = new HashMap();//2 board length, fence length
		{
			Set set1 = boards.entrySet();
			Iterator i1 = set1.iterator();
				  
			while (i1.hasNext()){
				Map.Entry me1 = (Map.Entry)i1.next();
				int x = Integer.parseInt(me1.getKey().toString());  ;
					
				Set set2 = boards.entrySet();
				Iterator i2 = set2.iterator();
					  
				while (i2.hasNext()){
					Map.Entry me2 = (Map.Entry)i2.next();
					int y = Integer.parseInt(me2.getKey().toString());  ;
						
					int L = x + y;
					map1.put(new Integer(L), new Integer(0));
				}
			}
		}
//
		Set set = map1.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) 
		{
			Map.Entry me = (Map.Entry)it.next();
			int L = Integer.parseInt(me.getKey().toString());
			
			int count = 0;

			Set set1 = boards.entrySet();
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
					if(boards.containsKey(L-x))
					{
						int n2 = Integer.parseInt(boards.get(L-x).toString());
						if(n2 > n)
							count += n;
						else
							count += n2;
					}
				}
			}
				
			me.setValue(count);
		  }

//
		HashMap map2 = new HashMap();//length
		
		it = set.iterator();
		while(it.hasNext()) 
		{
			Map.Entry me = (Map.Entry)it.next();
			
			int n = Integer.parseInt(me.getValue().toString());
			int v = 1;
			if(map2.containsKey(n))
			{
				v = Integer.parseInt(map2.get(n).toString()) + 1;
			}
			map2.put(n, new Integer(v));
		}
		
		List<Map.Entry> keys = new ArrayList<Map.Entry>(map2.entrySet());
		
		Collections.sort(keys, new Comparator<Map.Entry>() {

			public int compare(Map.Entry o1, Map.Entry o2) {
				return Integer.parseInt(o2.getKey().toString()) - Integer.parseInt(o1.getKey().toString());
			}
		});

		int lastkey = 0;
		Map.Entry me = (Map.Entry)keys.get(lastkey);
		System.out.println(me.getKey() + " " + me.getValue());
	}
}

import java.util.*;

public class j5
{
	public static void main(String [] args)
	{
		HashMap<Integer, String> alldata = new HashMap<Integer, String>();
		alldata.put(1, "6");
		alldata.put(2, "6");
		alldata.put(3, "4,5,6,15");
		alldata.put(4, "3,5,6");
		alldata.put(5, "3,4,6");
		alldata.put(6, "1,2,3,4,5,7");
		alldata.put(7, "6,8");
		alldata.put(8, "7,9");
		alldata.put(9, "8,10,12");
		alldata.put(10, "9,11");
		alldata.put(11, "10,12");
		alldata.put(12, "9,11,13");
		alldata.put(13, "12,14,15");
		alldata.put(14, "13");
		alldata.put(15, "3,13");
		alldata.put(16, "17,18");
		alldata.put(17, "16,18");
		alldata.put(18, "16,17");

		Scanner sc = new Scanner(System.in);
		String type = "";
		int x1 = 0;
		int x = 0;
		int y = 0;

		for(int k = 0; !type.equals("q"); k++)
		{
			type = sc.next();
			if(type.equals("n") || type.equals("f"))
				x1 = sc.nextInt();
			else if(type.equals("d"))
			{
			}
			else if(type.equals("s"))
			{
			}
			else if(type.equals("i"))
			{
//				System.out.println("entered if statement top");
				x = sc.nextInt();
				y = sc.nextInt();

				Set set1 = alldata.entrySet();
				Iterator i1 = set1.iterator();
//				System.out.println("entered if statement");
					  
				while (i1.hasNext()){
//				System.out.println("while start");
					Map.Entry me1 = (Map.Entry)i1.next();
//				System.out.println("while");
					
					int akey = (Integer)me1.getKey();
					String avalue = (String)me1.getValue();

					System.out.println(akey+": "+x+"....."+avalue + "................");
					if(akey == x)
					{
				System.out.println("entered if");
						i1.remove();
						alldata.put(x, "" + avalue + "," + y);
					}
				}
					else
					{
				System.out.println("entered else");
						alldata.put(x, "" + y);
					}
				

			}
		}
//		System.out.println(x1);
//		System.out.println(x);
//		System.out.println(y);
		
		


/////////////////////
		System.out.println("----------");
		
		Set set1 = alldata.entrySet();
		Iterator i1 = set1.iterator();
			  
		while (i1.hasNext()){
			Map.Entry me1 = (Map.Entry)i1.next();
			System.out.println(me1.getKey() + ": " + me1.getValue());
		}
/////////////////
	}
	
}
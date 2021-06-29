import java.util.*;
public class j4
{
	String drctn = "";
	int move = 0;
	
	void calculate(String cdirection, int cmove)
	{
		// Create a hash map
		HashMap hm = new HashMap();

		// Put elements to the map
		hm.put("Zara", new Double(3434.34));
		hm.put("Mahnaz", new Double(123.22));
		hm.put("Ayan", new Double(1378.00));
		hm.put("Daisy", new Double(99.22));
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
      
        ArrayList<Entry<Integer, String>> array = new ArrayList<>();
        array.addAll(hash.entrySet());

        // Loop over ArrayList of Entry elements.
        for (Entry<Integer, String> entry : array) {
            // Use each ArrayList element.
            int key = entry.getKey();
            String value = entry.getValue();
		}
		
	//up value increase by moves
	if(drctn.equals('u'))
	{
		for(int i = 0; i <= move; i++)
		{
//			int x = hm.size());
//			int y = hm.get(Value());
//			hm.put("Zara", new Double(balance + 1000));
//			System.out.println("Zara's new balance: " + hm.get("Zara"));
	  
		}
	}
		
	//down
	//left
	//right
	//quit

	// Get a set of the entries
	Set set = hm.entrySet();

	// Get an iterator
	Iterator i = set.iterator();

	// Display elements
	while(i.hasNext()) {
		Map.Entry me = (Map.Entry)i.next();
		System.out.print(me.getKey() + ": ");
		System.out.println(me.getValue());
	}
      System.out.println();
      
      // Deposit 1000 into Zara's account
      double balance = ((Double)hm.get("Zara")).doubleValue();
      hm.put("Zara", new Double(balance + 1000));
      System.out.println("Zara's new balance: " + hm.get("Zara"));
   

	}
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			drctn = scanner.next();
			move = scanner.nextInt();
			
			calculate(drctn, move);
		}		
	}
	public static void main(String [] args)
	{
		j4 obj = new j4();
		obj.run();		
	}
}
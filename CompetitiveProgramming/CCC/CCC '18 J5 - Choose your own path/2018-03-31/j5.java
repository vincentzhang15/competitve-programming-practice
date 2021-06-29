import java.util.*;

public class j5
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		String page = s.nextLine();
		int pages = Integer.parseInt(page);
		
		TreeMap<Integer, ArrayList<Integer>> path = new TreeMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> separated = new ArrayList<Integer>();
		for(int i=0;i<pages;i++)
		{
			String line = s.nextLine();
			for(int j=0;j<line.length();j++)
			{
				String [] separate = line.split("\\s+");
				for(int k=0; k<separate.length; k++)
				{
					String word = separate[k];
					int number = Integer.parseInt(word);
					separated.add(number);
				}
				path.put(i, separated);
			}
		}
		for(int i=0;i<pages;i++)
		{
			System.out.println(" :"+path.get(i));
		}
	}
}
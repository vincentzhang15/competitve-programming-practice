import java.util.*;

public class j5
{
	static boolean surfable(String chooselink)
	{
		return false;
	}
	static String surfResults(String line)
	{
		return "";
	}
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int pages = s.nextInt();
		
		String line = "";
		ArrayList<String> link = new ArrayList<String>();
		for(int i = 0; i < pages; i++)
		{
			line = s.nextLine();
			boolean ADD = false;
			if(ADD)
			{
				link.add(line);
				ADD = false;
			}

			for(int j = 0; j < 7; j++)
			{
				String transfer = "";
				transfer += line.charAt(j);
			}

			if(line.equals("<A HREF="))
			{
				for(int j = 8; j < line.length(); j++)
				{
					if(line.charAt(j) == '"')
						break;
					String transfer = "";
					transfer += line.charAt(j);
				}
			}			
			if(line.equals("</HTML>"))
				ADD = true;
		}
		for(;;)
		{
			if(line.equals("The End"))
				break;
			String chooselink = s.nextLine();
			if(surfable(chooselink))
				System.out.println(surfResults(line));
			
		}
		for(int i = 0;; i++)
		System.out.print("from " + link.get(i) + " to ");
	
	}
}
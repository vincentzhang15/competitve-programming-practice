import java.util.*;

public class j5new
{
	TreeMap<String, ArrayList<String> > pages = new TreeMap<String, ArrayList<String> >();
	TreeSet<String> visited = new TreeSet<String>();
	
	boolean surfable(String from, String to)
	{
		//System.out.println(" surfable " + from + ", " + to);
		ArrayList<String> links = pages.get(from); 
		if(links == null)
		{
			//System.out.println(" links = null");
			return false;
		}
		
		for(int i=0; i<links.size(); i++)
		{
			String link = links.get(i);
			if(visited.contains(link))
				continue;
			visited.add(link);

			
			if(link.equals(to))
				return true;
			//else System.out.println(" link not equals to to " + link + ", " + to);
			
			if(surfable(link, to))
				return true;
		}
		return false;
	}
	
	void run()
	{
		Scanner s = new Scanner(System.in);
		int npages = s.nextInt();
		
		for(int i = 0; i < npages; i++)
		{
			String url = "";
			url = s.nextLine();
			if(url.length() < 3)
				url = s.nextLine();
			
			String content = "";
			while(true)
			{
				String h = s.nextLine();
				if(h.equals("</HTML>"))
					break;
				content += h;
			}
			
			ArrayList<String> list = new ArrayList<String>();
			for(int idx = content.indexOf('"'); idx != -1; idx = content.indexOf('"', idx+1))
			{
				int ide = content.indexOf('"', idx + 1);
				if(ide == -1)
					break;
				
				String link = content.substring(idx+1, ide);
				list.add(link);
				
				System.out.println("Link from "+ url + " to " + link);
				
				idx = ide;
			}
			
			pages.put(url, list);
			
			
			//System.out.println("");
			//System.out.println("page: " + url);
			//System.out.println("content: " + content);
			//System.out.println("list: " + list);
		}
		System.out.println("");
		//System.out.println("pages: " + pages);

		for(;;)
		{
			String from = s.nextLine();
			if(from.equals("The End"))
				break;
			String to = s.nextLine();
			
			visited.clear();
			
			if(surfable(from, to))
				System.out.println("Can surf from " + from + " to " + to);
			else
				System.out.println("Can't surf from " + from );
		}
	}
	
	public static void main(String [] args)
	{
		j5new j5 = new j5new();
		j5.run();
	}
}
import java.util.*;

public class j3_set
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String year = sc.next();
		
		TreeSet<Integer> years = new TreeSet<Integer>();
		
		for(int y = Integer.parseInt(year)+1; y<=20000;y++)
		{
			years.clear();
			
			int ny = 0;
			for(int w = y; w > 0; w /= 10)
			{
				ny ++;
				
				int v = w % 10;
				years.add(v);
			}

			if(years.size()==ny)
			{
				//System.out.println("ny="+ny+"  y="+y+" years="+years);
				System.out.println(y);
				return;
			}				
		}
	}
}
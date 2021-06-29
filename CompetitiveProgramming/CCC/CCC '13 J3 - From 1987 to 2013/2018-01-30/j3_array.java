import java.util.*;

public class j3_array
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String year = sc.next();
		
		int [] years = new int [5];
		
		for(int y = Integer.parseInt(year)+1; y<=20000;y++)
		{
			for(int i = 0; i<5; i++)
				years[i] = -1;
			
			int ny = 0;
			for(int w = y; w > 0; w /= 10)
			{
				ny ++;
				
				int v = w % 10;
				for(int j=0;j<5;j++)
				{
					//System.out.println("y="+y+" v="+v+" j="+j+"  ys="+years[j]);
					if(years[j] == v)
						break;
					if(years[j] == -1)
					{
						//System.out.println(" --- set y["+j+"]="+v);
						
						years[j] = v;
						break;
					}
				}
			}

			int n = 0;
			for(n=0;n<years.length;n++)
			{
				//System.out.println("y="+y+" n="+n+"  ys="+years[n]);
				
				if(years[n] == -1)
				{
					break;
				}
			}
			if(n == ny)
			{
				//System.out.println("ny="+ny+"  y="+y+" n="+n);
				System.out.println(y);
				return;
			}				
		}
	}
}
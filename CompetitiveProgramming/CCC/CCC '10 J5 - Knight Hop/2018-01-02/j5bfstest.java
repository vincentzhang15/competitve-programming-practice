import java.util.*;

public class j5bfs
{
	int [] m = new 
	calculate()
	{
		if(x1 + 1 <= 8 && y1 + 2 <= 8)
		{
			nd.finalcordinatesnumber = (((m[i] / 10) + 1)*10) + ((m[i] % 10) + 2);
		}
		//4
		if(x1 + 1 <= 8 && y1 - 2 > 0)
		{
			children.add((((m[i] / 10) + 1)*10) + ((m[i] % 10) - 2));
		}
		//8
		if(x1 - 1 > 0 && y1 + 2 <= 8)
		{
			children.add((((m[i] / 10) - 1)*10) + ((m[i] % 10) + 2));
		}				
		//5
		if(x1 - 1 > 0 && y1 - 2 > 0)
		{
			children.add((((m[i] / 10) - 1)*10) + ((m[i] % 10) - 2));
		}				
		//2
		if(x1 + 2 <= 8 && y1 + 1 <= 8)
		{
			children.add((((m[i] / 10) + 2)*10) + ((m[i] % 10) + 1));
		}				
		//3
		if(x1 + 2 <= 8 && y1 - 1 > 0)
		{
			children.add((((m[i] / 10) + 2)*10) + ((m[i] % 10) - 1));
		}				
		//7
		if(x1 - 2 > 0 && y1 + 1 <= 8)
		{
			children.add((((m[i] / 10) - 2)*10) + ((m[i] % 10) + 1));
		}				
		//6
		if(x1 - 2 > 0 && y1 - 1 > 0)
		{
			children.add((((m[i] / 10) - 2)*10) + ((m[i] % 10) - 1));
		}
	}
				
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		
		x1 = scanner.nextInt();
		y1 = scanner.nextInt();
		x2  = scanner.nextInt();
		y2 = scanner.nextInt();
		
		scord = (x1 * 10) + y1;
		
		m[0] = scord;
		
		ecord = (x2 * 10) + y2;

		System.out.println(scord);
		System.out.println(ecord);
		
		calculate();
	}
	
	public static void main(String [] args)
	{
		j5bfs obj = new j5bfs();
		obj.run();
	}
}

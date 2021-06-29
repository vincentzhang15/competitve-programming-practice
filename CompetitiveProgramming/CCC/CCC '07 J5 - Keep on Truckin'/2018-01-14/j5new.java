import java.util.Scanner;
import java.util.ArrayList;

public class j5new
{
	int ways;
	int min;
	int max;
	ArrayList<Integer> motel = new ArrayList<Integer>();

	void findPath (int distance)
	{
		if(distance == 7000)
		{
			ways += 1;
		}
		else
		{
			
			for(int i = 0; i < motel.size(); i++)
			{
				if(distance+min > motel.get(i))
					continue;

				if(distance+max < motel.get(i))
					continue;

				findPath(motel.get(i));
			}
		}
	}

	void run()
	{
		motel.add(0);
		motel.add(990);         
		motel.add(1010);         
		motel.add(1970);         
		motel.add(2030);         
		motel.add(2940);         
		motel.add(3060);         
		motel.add(3930);         
		motel.add(4060);         
		motel.add(4970);         
		motel.add(5030);       
		motel.add(5990);       
		motel.add(6010);       
		motel.add(7000);       

		Scanner scanner = new Scanner (System.in);
		
		min = scanner.nextInt();
		max = scanner.nextInt();
		int n = scanner.nextInt();

		for(int i = 0; i < n; i++)
			motel.add(scanner.nextInt());

		System.out.println(motel);
		
		
		findPath(0);

		System.out.println(ways);
	}
	public static void main(String [] args)
	{
		j5new obj = new j5new();
		obj.run();
	}
}

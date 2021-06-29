import java.util.Scanner;

public class j5
{
	int ways;
	int min;
	int max;
	int size;
	int	n;
	int [] motel = new int [9999];

	boolean between (int a, int b, int c)
	{
		if(a <= b && b <= c)
			return true;
		else return false;
	}

	void findPath (int distance)
	{
		if(distance == 7000)
		{
			System.out.println(" - -- - - -");
			ways += 1;
		}
		else
		{
//			System.out.println(" +++++++++" + distance);
//			System.out.println(" ++..." + min);
//			System.out.println(" ++..." + max);
			for(int i = 0; i < size; i++)
			{
			System.out.println("Motel: " + motel[i]);
				if(between (min, motel [i] - distance, max))
				{
					System.out.println(" ++...-----" + distance);
					distance += motel[i];
					findPath(motel[i]);
				}
			System.out.println(" ===========");
			}
		}
	}

	void run()
	{
		size = 13;
		motel [0] = 0;
		motel [1] = 990;         
		motel [2] = 1010;         
		motel [3] = 1970;         
		motel [4] = 2030;         
		motel [5] = 2940;         
		motel [6] = 3060;         
		motel [7] = 3930;         
		motel [8] = 4060;         
		motel [9] = 4970;         
		motel [10] = 5030;       
		motel [11] = 5990;       
		motel [12] = 6010;       
		motel [13] = 7000;       

		Scanner scanner = new Scanner (System.in);
		
		min = scanner.nextInt();
		max = scanner.nextInt();
		n = scanner.nextInt();

		for(int i = 1; i < n; i++)
			motel[i + size] = scanner.nextInt();

		size += n;

		findPath(0);

		System.out.println(ways);
	}
	public static void main(String [] args)
	{
		j5 obj = new j5();
		obj.run();
	}
}
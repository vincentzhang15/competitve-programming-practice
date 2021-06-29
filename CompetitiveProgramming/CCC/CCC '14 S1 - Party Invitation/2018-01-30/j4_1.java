import java.util.*;

public class j4_1
{
	void run()
	{
		Scanner scanner = new Scanner(System.in);

		int loop = scanner.nextInt();

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 1; i <= loop; i++)
			numbers.add(i);
		
		System.out.println(numbers);

		int rloop = scanner.nextInt();
		for(int i = 0; i < rloop; i++)
		{
			System.out.println("-------------------------loop " + i + "----------------------------------" + "/" + rloop);
			int sequence = scanner.nextInt();
			System.out.println("Sequence to be removed: " + sequence);
			
			for(int j = numbers.size(); j >0 ; j--)
			{
				System.out.println("Loop j: " + j);
				System.out.println("............                      " + numbers.size());
				System.out.println("............                                " + j % sequence);
				if(j % sequence == 0)
				{
					numbers.remove(j-1);
				}
			}
		}
		for(Integer id : numbers)
			System.out.println(id);
		
	}
	public static void main(String [] args)
	{
		j4_1 obj = new j4_1();
		obj.run();
	}
}
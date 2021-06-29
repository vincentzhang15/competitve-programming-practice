import java.util.*;

public class j4
{
	void run()
	{
		Scanner scanner = new Scanner(System.in);

		int loop = scanner.nextInt();

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> removeN = new ArrayList<Integer>();
		
		for(int i = 1; i <= loop; i++)
			numbers.add(i);
		
		System.out.println(numbers);

		int rloop = scanner.nextInt();
		for(int i = 0; i < rloop; i++)
		{
			System.out.println("-------------------------loop " + i + "----------------------------------" + "/" + rloop);
			int sequence = scanner.nextInt();
			System.out.println("Sequence to be removed: " + sequence);
			for(int j = 1; j <= numbers.size(); j++)
			{
				System.out.println("Loop j: " + j);
				System.out.println("............                      " + numbers.size());
				System.out.println("............                                " + j % sequence);
				if(j % sequence == 0)
				{
					System.out.println("Entered if");
					removeN.add(j-1);
				}
				System.out.println(removeN);
			}
			for(int j = 0; j <= numbers.size(); j++)
			{
				numbers.remove(removeN);
				System.out.println(numbers);
			}
		}
	}
	public static void main(String [] args)
	{
		j4 obj = new j4();
		obj.run();
	}
}
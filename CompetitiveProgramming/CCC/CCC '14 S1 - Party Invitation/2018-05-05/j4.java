import java.util.*;

public class j4
{
	ArrayList<Integer> person = new ArrayList<Integer>();
	int people, rounds;
	int [] remove;

	void print()
	{
		System.out.println("-----------------------------");
		System.out.print("People: " + people + "  Rounds: " + rounds + " | ");
		for(int i = 0; i < rounds; i++)
			System.out.print(" " + remove[i]);
		System.out.println();

		System.out.print("List: ");
		for(int i = 0; i < person.size(); i++)
			System.out.print(person.get(i) + " ");
		System.out.println("\n-----------------------------");
	}
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		people = scanner.nextInt();
		rounds = scanner.nextInt();
		remove = new int [rounds];

		for(int i = 1; i <= people; i++)
			person.add(i);
		for(int i = 0; i < rounds; i++)
			remove[i] = scanner.nextInt();
		
		int multiple;
		for(int i = 0; i < rounds; i++)
		{
			multiple = remove[i];
			//System.out.println(multiple);
			for(int j = person.size(); j > 0; j--)
			{
				if(j % multiple == 0)
					person.remove(j - 1);
			}
			//System.out.println();
		}
		for(int i = 0; i < person.size(); i++)
			System.out.println(person.get(i));
	}
	public static void main(String [] args)
	{
		j4 obj = new j4();
		obj.run();
	}
}


/*
		int multiple;
		for(int i = 0; i < rounds; i++)
		{
			multiple = remove[i];
			for(i = person.size() - 1; i >= 0; i--)
			{
				System.out.println(i+1);
				if(i % multiple == 0)
				{
					System.out.print(" : " + multiple);
					person.remove(i + 1);
					printPeople();
				}
			}
			//System.out.println();
		}
*/
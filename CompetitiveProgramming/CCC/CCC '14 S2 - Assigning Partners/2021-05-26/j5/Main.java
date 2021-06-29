import java.util.*;

public class Main
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int people = scanner.nextInt();
		String [] listA = new String [people];
		String [] listB = new String [people];
		
		for(int i = 0; i < people; i++)
			listA[i] = scanner.next();
		for(int i = 0; i < people; i++)
			listB[i] = scanner.next();
		
		for(int i = 0; i < people; i++)
			for(int j = 0; j < people; j++)
				if(listA[i].equals(listB[j]))
					if(listB[i].equals(listA[j]))
					{
						if(i == j)
						{
							System.out.println("bad");
							return;
						}							
					}
					else
					{
						System.out.println("bad");
						return;
					}
		System.out.println("good");
	}
}
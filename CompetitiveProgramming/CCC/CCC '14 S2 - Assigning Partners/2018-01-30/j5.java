import java.util.*;

public class j5
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int friends = scanner.nextInt();
		
		String [] A = new String [friends];
		String [] B = new String [friends];

		for(int i = 0; i < friends; i++)
			A[i] = scanner.next();

		for(int i = 0; i < friends; i++)
			B[i] = scanner.next();

		for(int i = 0; i < friends; i++)
		{
			String a = A[i];
			String b = B[i];
			if(a.equals(b))
			{
				System.out.println("bad");
				return;
			}

			for(int j = 0; j < friends; j++)
			{
				if(b.equals(A[j]))
				{
					if(B[j].equals(a))
						continue;
					else
					{
						System.out.println("bad");
						return;
					}
				}
			}
		}
		System.out.println("good");
	}
}
import java.util.*;

public class j5
{
	int [] invites;
	int N;

	class Node
	{
		int totalposibilities()
		{
			int [] c = new int [N];
			
			int ctotal = 0;
			
			int [] denominatorarr = new int [N];
			int denominator = 0;

			int [] rfactorialarr = new int [N];
			int rfactorial = 0;
			
			int [] numeratorarr = new int [N];
			
			for(int i = 0; i < N; i++)
			{
				int numerator = invites[i];
				for(int j = 0; numerator > 0; j++)
					numerator *= (numerator - 1);

					numeratorarr[i] = numerator;
			}
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
					rfactorial *= (rfactorial - 1);

				rfactorialarr[i] = rfactorial;
			}
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
					denominator = rfactorialarr[i] * (numeratorarr[i] - rfactorialarr[i]);

				denominatorarr[i] = denominator;
			}
			
			for(int i = 0; i < N; i++)
			{
				if(denominatorarr[i] == 0)
					denominatorarr[i] = 1;

				c[i] = numeratorarr[i] / denominatorarr[i];
			}
			
			for(int i = 0; i < N; i++)
				ctotal += c[i];
			
			return ctotal;
		}
	}
	
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		Node node = new Node(N);
		invites = new int [N];
		for(int i = 0; i < N - 1; i++)
		{
			node.invites[i] = scanner.nextInt();
		}

//		System.out.println(totalposibilities());
	}

	public static void main (String [] args)
	{
		j5 obj = new j5();
		obj.run();
	}
}

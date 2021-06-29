import java.util.Scanner;
public class j5_2
{
	int rounds;

	int [] a = new int [99999];
	int [] b = new int [99999];
	int [] c = new int [99999];
	int [] d = new int [99999];
	
	int a1;
	int b1;
	int c1;
	int d1;

	int j = 0;
	int move (int a1, int b1, int c1, int d1)
	{
		for(int i = 0;; i++)
		{
			if(a1 > 0 && b1 > 0 && c1 > 0 && d1 > 0)
			{
				move(a1 - 2, b1 - 1, c1 - 0, d1 - 2);//, step + 1);
				j++;
//				System.out.println(step);          );//
				move(a1 - 1, b1 - 1, c1 - 1, d1 - 1);//, step + 1);
				j++;
//				System.out.println(step);          );//
				move(a1 - 0, b1 - 0, c1 - 2, d1 - 1);//, step + 1);
				j++;
//				System.out.println(step);          );//
				move(a1 - 0, b1 - 3, c1 - 0, d1 - 0);//, step + 1);
				j++;
//				System.out.println(step);          );//
				move(a1 - 1, b1 - 0, c1 - 0, d1 - 1);//, step + 1);
				j++;
//				System.out.println(step);
			}
			return j;
		}
	}

	void run()
	{
		Scanner scanner = new Scanner(System.in);
		rounds = scanner.nextInt();

		for(int i = 0; i < rounds; i++)
		{
			a[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
			c[i] = scanner.nextInt();
			d[i] = scanner.nextInt();
			
			a1 = a[i];
			b1 = b[i];
			c1 = c[i];
			d1 = d[i];
			move(a1, b1, c1, d1);
			System.out.println(move(a1, b1, c1, d1));
				System.out.println(j);
			if(move(a1, b1, c1, d1) % 2 != 0)
				System.out.println("Patrick");
			else
				System.out.println("Roland");
		}
/*		
		for(int i = 0; i < rounds; i++)
			System.out.println("a: " + a[i]);
		
		for(int i = 0; i < rounds; i++)
			System.out.println("b: " + b[i]);
		
		for(int i = 0; i < rounds; i++)
			System.out.println("c: " + c[i]);
		
		for(int i = 0; i < rounds; i++)
			System.out.println("d: " + d[i]);
*/	}

	public static void main(String [] args)
	{
		j5_2 obj = new j5_2();
		obj.run();
	}
	
}
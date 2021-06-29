import java.util.*;

public class s1
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int runs = s.nextInt();
		
		int [] swi = new int [runs];
		int [] sem = new int [runs];
		int swiTotal = 0;
		int semTotal = 0;
		
		for(int i = 0; i < runs; i++)
		{
			swi[i] = s.nextInt();
			swiTotal += swi[i];
		}
		for(int i = 0; i < runs; i++)
		{
			sem[i] = s.nextInt();
			semTotal += sem[i];
		}

		for(int i = runs - 1; i >= 0; i--)
		{
			if(swiTotal == semTotal)
			{
				System.out.println(i + 1);
				return;
			}

			swiTotal -= swi[i];
			semTotal -= sem[i];
		}
		System.out.println(0);
	}
}
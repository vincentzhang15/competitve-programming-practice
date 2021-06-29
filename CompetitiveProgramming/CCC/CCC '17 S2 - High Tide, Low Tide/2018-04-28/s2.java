import java.util.*;

public class s2
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		
		int [] total = new int [data];
		ArrayList<Integer> low = new ArrayList<Integer>();
		ArrayList<Integer> high = new ArrayList<Integer>();
		int middle;
		int two = 2;
		
		for(int i = 0; i < data; i++)
			total[i] = s.nextInt();

		if(data % 2 == 0)
			middle = data / two;
		else
			middle = data / two + 1;

		Arrays.sort(total);
		
		for(int i = 0; i < middle; i++)
			low.add(total[i]);
		for(int i = middle; i < data; i++)
			high.add(total[i]);

//		System.out.print(low);
//		System.out.print(high);
//		System.out.println();

		Collections.sort(high);
		Collections.sort(low);
		Collections.reverse(low);

//		System.out.print(low);
//		System.out.print(high);
//		System.out.println();

		for(int i = 0; i < middle; i++)
		{
			System.out.print(low.get(i) + " ");
			if(data % 2 != 0 && i == middle - 1)
				break;
			System.out.print(high.get(i) + " ");
		}
	}
}
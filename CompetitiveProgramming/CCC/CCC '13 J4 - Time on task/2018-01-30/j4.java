import java.util.*;

public class j4
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int chores = sc.nextInt();
		
		ArrayList<Integer> choose = new ArrayList<Integer>();
		
		for(int i = 0; i < chores; i++)
			choose.add(sc.nextInt());

		Collections.sort(choose, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2){
				return o1 - o2;
			}
		});

		int i = 0;
		int sum = 0;
		while(sum <= time)
		{
			sum += choose.get(i);
			i++;
		}
		System.out.println(i-1);
	}
}
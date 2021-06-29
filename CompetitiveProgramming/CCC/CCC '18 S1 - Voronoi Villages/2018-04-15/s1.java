import java.util.*;

public class s1
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int villages = s.nextInt();
		int [] pos = new int [villages];
		for(int i = 0; i < villages; i++)
			pos[i] = s.nextInt();
		Arrays.sort(pos);
		
		double min = Double.MAX_VALUE;
		for(int i = 0; i < villages-2; i++)
		{
			double diff = (double)(pos[i+2] + pos[i+1])/2 - (double)(pos[i+1] + pos[i])/2;
//			System.out.println(pos[i+2] + " " + pos[i+1] + " " + pos[i+1] + " " + pos[i] + " : " + diff);
//			System.out.println("diff: " + diff);
			if(diff < min)
				min = diff;
		}
		String answer = String.format("%.1f", min);
		System.out.println(answer);
	}
}
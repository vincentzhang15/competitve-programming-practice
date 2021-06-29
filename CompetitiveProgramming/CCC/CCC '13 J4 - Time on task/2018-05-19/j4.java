import java.util.*;

public class j4
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int time = scanner.nextInt();
		int nchores = scanner.nextInt();
		int [] chores = new int [nchores];
		
		for(int i = 0; i < nchores; i++)
			chores[i] = scanner.nextInt();
		Arrays.sort(chores);
		
		int timeTaken = 0;
		for(int i = 0; i < nchores; i++)
		{
			//System.out.println(i + ": " + timeTaken + "/" + time);
			if(timeTaken > time)
			{
				System.out.println(i-1);
				return;
			}
			else if(timeTaken == time)
			{
				System.out.println(i);
				return;
			}
			timeTaken += chores[i];

		}
	}
}
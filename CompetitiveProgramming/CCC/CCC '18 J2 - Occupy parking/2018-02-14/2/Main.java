import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();		
		String yesterday = in.next();
		String today = in.next();
		int count = 0;
		//System.out.println("=============="+yesterday);
		for(int i=1; i<=size; i++)
		{
			//System.out.println("@@@@@@@@@@@yesterday:"+yesterday.substring(i-1,i));
			//System.out.println("@@@@@@@@@@@today:"+today.substring(i-1,i));	
					
			if((yesterday.substring(i-1,i)).equals(today.substring(i-1,i)))
			{
				//System.out.println("INNNNNNNNNNNNNNNNNNNNNNNNNNn");
				if((yesterday.substring(i-1,i)).equals("C")	)
					count++;
			}
		}
		System.out.println(count);
	}
}
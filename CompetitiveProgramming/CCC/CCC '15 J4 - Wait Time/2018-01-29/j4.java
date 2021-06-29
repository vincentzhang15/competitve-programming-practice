import java.util.*;
public class j4
{
	void run()
	{
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		
		TreeSet<Integer> 
		char [] command = new char [loop];
		int [] value = new int [loop];
		for(int i = 0; i < loop; i++)
		{
			command[i] = sc.next().charAt(i);
			value[i] = sc.nextInt();
		}
		
		
	}
	public static void main (String [] args)
	{
		j4 obj = new j4();
		obj.run();
	}
	
}
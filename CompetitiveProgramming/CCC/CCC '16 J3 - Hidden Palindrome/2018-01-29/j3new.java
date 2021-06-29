//10:54
import java.util.Scanner;
import java.util.ArrayList;

public class j3new
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		String original = scanner.next();
		
		int len = original.length();
		int result = 1;
		String newstr=original.substring(1,2);
		
		for(int i = 0; i < len-1; i++)
		{
			for(int j = i+1; j < len; j++)
			{
				// [i .. j]
				int current_length = j-i+1;
				boolean fail = false;
				for(int k = 0; k < (current_length)/2; k++)
				{
					if(original.charAt(i+k) != original.charAt(j-k))
					{
						fail = true;
						break;
					}
				}
				if(!fail)
				{
					if(current_length > result) 
					{
						result = current_length;
						newstr = original.substring(i,j+1);
					}
				}
			}
		}

		System.out.println();
		System.out.println(original);
		System.out.println();
		System.out.println("length = " + result);
		System.out.println(newstr);
	}
}
//11:
//9:15
//9:20
import java.util.Scanner;
public class j3old
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int scale = scanner.nextInt();

		String arr[][]={{"*","X","*"},{" ","X","X"},{"*"," ","*"}};  

		for(int i = 0;i < 3;i ++)
		{  
			for(int j = 0;j < 3;j++)
			{
				for(int k = 0; k < scale; k++)
				{
					System.out.print(arr[i][j]+" ");

				}	
			}
			for(int a = 0; a < scale;a ++)
			{
				System.out.println("");
			}

		}
	}
}
//10:04
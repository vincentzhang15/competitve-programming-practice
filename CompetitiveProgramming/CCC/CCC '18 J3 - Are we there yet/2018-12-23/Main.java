import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nCities = 5;
		int [] distance = new int [4];
		
		String input  = br.readLine();
		String [] strs = input.trim().split("\\s+");
		for(int i=0; i<4; i++)
			distance[i] = Integer.parseInt(strs[i]);
		
		for(int i=0; i<nCities; i++)
		{
			System.out.println("------------------- " + i);
			int top = 0;
			int bottom = 0;
			for(int j=0; j<nCities; j++)
			{
				if(i==j)
					System.out.print(0 + " ");
				else
				{
					if(j>i)
					{
						top += distance[j-1];
						System.out.print(top + " ");
					}
					else
					{
						for(int k = 0; k < i; k++)
							bottom += distance[k];
						bottom -= distance[i-j-1];
						System.out.print(bottom + " ");
					}
				}
			}
			System.out.println();
		}
	}
}
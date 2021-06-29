import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TheMirror
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] data = new int [n][2];
		
		int largest = 0;
		for(int i = 0; i < n; i++)
		{
			String [] line = br.readLine().split(" ");
			data[i][0] = Integer.parseInt(line[0]);
			data[i][1] = Integer.parseInt(line[1]);
			
			if(data[i][1] > largest)
				largest = data[i][1];
		}
		
		boolean [] notPrime = new boolean[largest+1];
		notPrime[1] = true;
		for(int i = 2; i < largest; i++)
		{
			if(!notPrime[i])
			{
				for(int j = 2; j < largest; j++)
				{
					if(i*j >= largest)
						break;
					notPrime[i*j] = true;
				}
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			int count = 0;
			for(int j = data[i][0]; j < data[i][1]; j++)
			{
				if(!notPrime[j])
					count++;
			}
			System.out.println(count);
		}
	}
}
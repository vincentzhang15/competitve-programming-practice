import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Army
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] line1 = br.readLine().split(" ");
		String[] line2 = br.readLine().split(" ");
		
		int[] data1 = Arrays.stream(line1).mapToInt(Integer::parseInt).toArray();
		int[] data2 = Arrays.stream(line2).mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(data1);
		Arrays.sort(data2);
		
		int max = -1;
		for(int i = 0; i < data1.length; i++)
		{
			int diff = Math.abs(data1[i] - data2[i]);
			if(diff > max)
				max = diff;
		}
		System.out.println(max);
	}
}
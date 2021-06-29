import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class PerfectTeam
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]); // Pokemons
		int m = Integer.parseInt(line[1]); // Choices
		int k = Integer.parseInt(line[2]); // Type
		
		List<Integer> remain = new ArrayList<>();
		int[] max = new int[k+1];
		
		for(int i = 0; i < n; i++)
		{
			line = br.readLine().split(" ");
			int t = Integer.parseInt(line[0]);
			int l = Integer.parseInt(line[1]);
			
			if(max[t] == 0)
				max[t] = l;
			else if(max[t] > l)
				remain.add(l);
			else
			{
				remain.add(max[t]);
				max[t] = l;
			}
		}
		
		long total = 0;
		for(int i = 1; i < max.length; i++)
			total += max[i];
		
		remain.sort(Comparator.reverseOrder());
		int i = 0;
		for(int val : remain)
		{
			if(i >= m-k)
				break;
			total += val;
			i++;
		}
		System.out.println(total);
	}
}
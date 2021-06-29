import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BloodDistribution
{
	static int[] supply, demand;
	static int people = 0;
	
	static void calc(int[] data)
	{
		int stock = 0;
		for(int i : data)
			stock += supply[i];

		int bags = Math.min(stock, demand[data[0]]);
		people += bags;
		demand[data[0]] -= bags;
		
		for(int i : data)
		{
			int most = Math.min(supply[i], bags);
			supply[i] -= most;
			bags -= most;
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		supply = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		demand = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		calc(new int[]{0});
		calc(new int[]{1, 0});
		calc(new int[]{2, 0});
		calc(new int[]{3, 2, 1, 0});
		calc(new int[]{4, 0});
		calc(new int[]{5, 4, 1, 0});
		calc(new int[]{6, 4, 2, 0});
		calc(new int[]{7, 6, 5, 4, 3, 2, 1, 0});
		System.out.println(people);
	}
}

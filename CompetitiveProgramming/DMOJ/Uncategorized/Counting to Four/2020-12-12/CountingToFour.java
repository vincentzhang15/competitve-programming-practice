import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CountingToFour
{
	static TreeMap<Integer, Integer> data = new TreeMap<Integer, Integer>();
	static void calculate()
	{
		TreeMap<Integer, Integer> lengths = new TreeMap<Integer, Integer>();
		lengths.put(1, 3);
		lengths.put(2, 3);
		lengths.put(3, 5);
		lengths.put(4, 4);
		lengths.put(5, 4);
		lengths.put(6, 3);
		lengths.put(7, 5);
		lengths.put(8, 5);
		lengths.put(9, 4);
		lengths.put(10, 3);
		lengths.put(11, 6);
		lengths.put(12, 6);
		lengths.put(13, 8);
		lengths.put(14, 8);
		lengths.put(15, 7);
		lengths.put(16, 7);
		lengths.put(17, 9);
		lengths.put(18, 8);
		lengths.put(19, 8);
		lengths.put(20, 6);
		lengths.put(30, 6);
		lengths.put(40, 5);
		lengths.put(50, 5);
		lengths.put(60, 5);
		lengths.put(70, 7);
		lengths.put(80, 6);
		lengths.put(90, 6);
		lengths.put(100, 7);
		lengths.put(1000, 8);

// 10 000 = tenthousand
// 100 000 = onehundredthousand
// 1 000 000 = onemillion
// 10 000 000 = tenmillion
// 100 000 000 = onehundredmillion
// 1 000 000 000 = onebillion		
		for(int i = 1; i <= 1000000000; i++)
		{
			// 1234
			int digit = i%100; // 34
			int remain = i/100; // 123
			int place = 1; // ones
			int total = lengths[digit*place]; // four = +4

			while(remain > 0)
			{
				digit = remain%10; // 123%10 = 3
				remain /= 10; // 123/10 = 12
				place *= 10; // tens
				total += lengths[digit*place]; // thirty = +6
			}
			System.out.println(total);
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		calculate();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	}
}



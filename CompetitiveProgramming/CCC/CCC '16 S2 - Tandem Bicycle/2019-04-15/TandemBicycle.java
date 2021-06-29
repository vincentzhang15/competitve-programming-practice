import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TandemBicycle
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String [] line1 = br.readLine().split(" ");
		String [] line2 = br.readLine().split(" ");
		
		ArrayList<Integer> dmoj = new ArrayList<Integer>();
		ArrayList<Integer> peg = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
		{
			dmoj.add(Integer.parseInt(line1[i]));
			peg.add(Integer.parseInt(line2[i]));
		}
		
		Collections.sort(dmoj);
		Collections.sort(peg);
		int count = 0;
		if(q == 2)
			Collections.reverse(peg);
		for(int i = 0; i < n; i++)
			count += Math.max(dmoj.get(i), peg.get(i));
		System.out.println(count);
	}
}
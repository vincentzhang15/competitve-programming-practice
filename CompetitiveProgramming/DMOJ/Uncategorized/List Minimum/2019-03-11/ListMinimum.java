import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListMinimum
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			list.add(Integer.parseInt(br.readLine()));
		
		while(list.size() > 0)
		{
			int minimum = list.get(0);
			int index = 0;
			for(int i = 0; i < list.size(); i++)
			{
				if(list.get(i) < minimum)
				{
					minimum = list.get(i);
					index = i;
				}
			}
			System.out.println(minimum);
			list.remove(index);
		}
	}
}
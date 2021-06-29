import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Ragaman
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s1 = br.readLine().split("");
		String [] s2 = br.readLine().split("");
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i = 0; i < s1.length; i++)
			list1.add(s1[i]);
		for(int i = 0; i < s2.length; i++)
			list2.add(s2[i]);
		
		Collections.sort(list1);
		Collections.sort(list2);
		for(int i = 0; i < list2.size(); i++)
		{
			if(list1.contains(list2.get(i)))
			{
				list1.remove(list2.get(i));
				list2.remove(list2.get(i));
				i = -1;
			}
		}
		
		for(int i = 0; i < list2.size(); i++)
		{
			if(!list2.get(i).equals("*"))
			{
				System.out.println("N");
				return;
			}
		}
		System.out.println("A");
	}
}
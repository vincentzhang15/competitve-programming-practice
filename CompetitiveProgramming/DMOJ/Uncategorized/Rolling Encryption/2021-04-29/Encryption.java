import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Encryption
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int[] frequency = new int[26];
		for(int j = 0; j < k; j++)
			frequency[s.charAt(j) - 'a']++;
		System.out.print(s.substring(0, k));

		for(int i = k; i < s.length(); i++)
		{
			int maxIdx = 0;
			for(int j = 1; j < 26; j++)
				if(frequency[j] > frequency[maxIdx])
					maxIdx = j;
			System.out.print((char)((s.charAt(i)-'a' + maxIdx+1)%26 + 'a'));
			
			frequency[s.charAt(i) - 'a']++;
			frequency[s.charAt(i-k) - 'a']--;
		}
	}
}
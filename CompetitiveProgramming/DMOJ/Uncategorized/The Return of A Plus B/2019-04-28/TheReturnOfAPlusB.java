import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TheReturnOfAPlusB
{
	static int convert(String c)
	{
		if(c.equals("zero") || c.equals("零") ) return 0;
		if(c.equals("one") || c.equals("un") || c.equals("一")) return 1;
		if(c.equals("two") || c.equals("deux") || c.equals("二")) return 2;
		if(c.equals("three") || c.equals("trois") || c.equals("三")) return 3;
		if(c.equals("four") || c.equals("quatre") || c.equals("四")) return 4;
		if(c.equals("five") || c.equals("cinq") || c.equals("五")) return 5;
		if(c.equals("six") || c.equals("六")) return 6;
		if(c.equals("seven") || c.equals("sept") || c.equals("七")) return 7;
		if(c.equals("eight") || c.equals("huit") || c.equals("八")) return 8;
		if(c.equals("nine") || c.equals("neuf") || c.equals("九")) return 9;
		if(c.equals("ten") || c.equals("dix") || c.equals("十")) return 10;
		return Integer.parseInt(String.valueOf(c));
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String [] data = br.readLine().split(" ");
			System.out.println(Integer.parseInt(data[0]) + Integer.parseInt(data[1]));
			//System.out.println(convert(data[0]) + convert(data[1]));
		}
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ecoo15r1p1
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		for(int k = 0; k < 10; k++)
		{
			int[] data = new int[8]; // orange blue green yellow pink violet brown red.
			while(!(line = br.readLine()).equals("end of box"))
			{
				if(line.equals("orange")) data[0]++;
				if(line.equals("blue")) data[1]++;
				if(line.equals("green")) data[2]++;
				if(line.equals("yellow")) data[3]++;
				if(line.equals("pink")) data[4]++;
				if(line.equals("violet")) data[5]++;
				if(line.equals("brown")) data[6]++;
				if(line.equals("red")) data[7]++;
			}
			
			int total = 0;
			for(int i = 0; i < 7; i++)
				total += Math.ceil(data[i]/7.0)*13.0;
			total += data[7]*16.0;
			System.out.println(total);
		}
	}
}
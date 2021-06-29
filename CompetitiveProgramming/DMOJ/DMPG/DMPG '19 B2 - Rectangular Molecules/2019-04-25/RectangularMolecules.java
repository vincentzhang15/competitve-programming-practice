import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RectangularMolecules
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		int one = Integer.parseInt(line[0]);
		int two = Integer.parseInt(line[1]);
		int three = Integer.parseInt(line[2]);
		int four = Integer.parseInt(line[3]);
		
		int largest = -1;
		for(int i = 0 ; i < 4; i++)
			if(Integer.parseInt(line[i]) > largest)
				largest = Integer.parseInt(line[i]);
			
		int second = -1;
		for(int i = 0 ; i < 4; i++)
			if(Integer.parseInt(line[i]) > second && Integer.parseInt(line[i]) != largest)
				second = Integer.parseInt(line[i]);
		
		if((one == largest && three == second) || (two == largest && four == second) || (one == second && three == largest) || (two == second && four == largest))
			System.out.println("trans");
		else
			System.out.println("cis");
	}
}
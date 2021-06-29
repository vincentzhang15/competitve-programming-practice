import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class BabblingBrooks
{
	public static void main (String [] args) throws IOException
	{
		ArrayList<Double> data = new ArrayList<Double>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			double d = Double.parseDouble(br.readLine());
			data.add(d);
		}
		
		while(true)
		{
			String command = br.readLine();
			if(command.equals("77"))
			{
				for(double d : data)
					System.out.print(Math.round(d) + " ");
				return;
			}
			else if(command.equals("88"))
			{
				int d = Integer.parseInt(br.readLine());
				data.set(d-1, data.get(d-1) + data.get(d));
				data.remove(d);
			}
			else
			{
				int d = Integer.parseInt(br.readLine());
				int s = Integer.parseInt(br.readLine());
				double total = data.get(d-1);
				double left = total * s/100.0;
				double right = total - left;
				
				data.set(d-1, left);
				data.add(d, right);
			}
		}
	}
}
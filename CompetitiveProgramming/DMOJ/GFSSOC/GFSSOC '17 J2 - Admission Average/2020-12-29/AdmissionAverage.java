import java.util.*;
import java.io.*;

public class AdmissionAverage
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double sum = 0;
		for(int i = 0; i < 6; i++)
			sum += Integer.parseInt(br.readLine());
		sum /= 6;
		sum += Integer.parseInt(br.readLine());
		if(sum >= Integer.parseInt(br.readLine()))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
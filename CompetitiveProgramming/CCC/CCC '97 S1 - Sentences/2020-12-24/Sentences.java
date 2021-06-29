import java.util.*;
import java.io.*;

public class Sentences
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			int ns = Integer.parseInt(br.readLine());
			int nv = Integer.parseInt(br.readLine());
			int no = Integer.parseInt(br.readLine());
			
			String [] s = new String [ns];
			String [] v = new String [nv];
			String [] o = new String [no];
			
			for(int j = 0; j < ns; j++)
				s[j] = br.readLine();
			for(int j = 0; j < nv; j++)
				v[j] = br.readLine();
			for(int j = 0; j < no; j++)
				o[j] = br.readLine();
			
			for(int j = 0; j < ns; j++)
				for(int k = 0; k < nv; k++)
					for(int l = 0; l < no; l++)
						System.out.println(s[j] + " " + v[k] + " " + o[l] + ".");
			System.out.println();
		}
	}
}
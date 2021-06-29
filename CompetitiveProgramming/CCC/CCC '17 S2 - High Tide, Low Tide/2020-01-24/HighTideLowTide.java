import java.io.*;
import java.util.*;

public class HighTideLowTide
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String length = br.readLine();
		String [] list = br.readLine().split(" ");
		
		int [] nList = new int [list.length];
		for(int i = 0; i < list.length; i++)
			nList[i] = Integer.parseInt(list[i]);
		Arrays.sort(nList);
		
		if(list.length % 2 == 0)
			for(int i = 0; i < nList.length/2; i++)
			{
				System.out.print(nList[nList.length/2-1-i] + " ");
				System.out.print(nList[nList.length/2+i] + " ");
			}
		else
		{
			System.out.print(nList[nList.length/2] + " ");
			for(int i = 0; i < nList.length/2; i++)
			{
				System.out.print(nList[nList.length/2+1+i] + " ");
				System.out.print(nList[nList.length/2-1-i] + " ");
			}
		}
	}
}
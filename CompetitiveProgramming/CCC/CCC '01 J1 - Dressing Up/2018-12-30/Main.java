import java.io.BufferedReader;import java.io.InputStreamReader;import java.io.IOException;public class Main{	public static void main (String [] args) throws IOException	{		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		int h = Integer.parseInt(br.readLine());				for(int i = 1; i <= h; i++)		{			for(int j = 0; j < h*2; j++)			{				if(i <= h/2)				{					if(j <= (i-1)*2 || j >= (h*2-1)-(i-1)*2)						System.out.print("*");					else						System.out.print(" ");				}				else				{				if(j < (h*2-1)-(i-1)*2 || j > (i-1)*2)						System.out.print("*");					else						System.out.print(" ");				}			}			System.out.println();		}	}}
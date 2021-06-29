import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] data = new int [3][3];
		for(int i = 0; i < 3; i++)
		{
			String [] line = br.readLine().split(" ");
			for(int j = 0; j < 3; j++)
			{
				if(line[j].equals("X"))
					data[i][j] = -10000000;
				else
					data[i][j] = Integer.parseInt(line[j]);
			}
		}
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(data[i][j] == -10000000)
				{
					int n1 = 0;
					int n2 = 0;
					int n3 = 0;
					int n4 = 0;
					if(i == 0)
					{
						if(j == 0)
						{
							n1 = data[i][j+1];
							n2 = data[i][j+2];
							n3 = data[i+1][j];
							n4 = data[i+2][j];
							
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}

						}
						if(j == 1)
						{
							n3 = data[i+1][j];
							n4 = data[i+2][j];
							n1 = data[i][j-1];
							n2 = data[i][j+1];
							/*
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}
							*/
							data[i][j] = (data[i][j-1] + data[i][j+1])/2;
							
						}
						if(j == 2)
						{
							
							n3 = data[i+1][j];
							n4 = data[i+2][j];
							n2 = data[i][j-2];
							n1 = data[i][j-1];
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}

						}
					}
					else if (i == 1)
					{
						if(j == 0)
						{
							/*
							n1 = data[i-1][j];
							n2 = data[i+1][j];
							n3 = data[i][j+1];
							n4 = data[i][j+2];
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}*/
							data[i][j] = (data[i][j-1] + data[i][j+1])/2;

							
						}
						if(j == 1)
						{
							n1 = data[i-1][j];
							n2 = data[i+1][j];
							n3 = data[i][j-1];
							n4 = data[i][j+1];
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}

						}
						if(j == 2)
						{
							n1 = data[i-1][j];
							n2 = data[i+1][j];
							n4 = data[i][j-2];
							n3 = data[i][j-1];
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}
							
						}
					}
					else if (i == 2)
					{
						if(j == 0)
						{
							n1 = data[i-2][j];
							n2 = data[i-1][j];
							n3 = data[i][j+1];
							n4 = data[i][j+2];
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}
							
						}
						if(j == 1)
						{
							/*
							n1 = data[i-2][j];
							n2 = data[i-1][j];
							n3 = data[i][j-1];
							n4 = data[i][j+1];
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}
							*/
							data[i][j] = (data[i][j-1] + data[i][j+1])/2;

						}
						if(j == 2)
						{
							n1 = data[i-2][j];
							n2 = data[i-1][j];
							n4 = data[i][j-2];
							n3 = data[i][j-1];
							if(n1 == -10000000 || n2 == -10000000)
							{
								data[i][j] = n3-n4+n3;
							}
							else if(n3 == -10000000 || n4 == -10000000)
							{
								data[i][j] = n1-n2+n1;
							}
							
						}
					}
				}
				//System.out.println(data[i][j]);
			}
		}
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}
}
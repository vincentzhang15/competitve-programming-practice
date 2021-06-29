import java.util.*;
public class Main
{
	void run()
	{
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();		
		int[][] inputArray = new int[size][size];	
		int[][] outputArray = new int[size][size];				
		for(int i=0; i<size; i++)		
		{
			for(int j=0; j<size; j++)
			{
				inputArray[i][j] = in.nextInt();				
			}
		}
		if(isOriginal(inputArray, size))
		{
			for(int i=0; i<size; i++)		
			{
				for(int j=0; j<size; j++)
				{
					System.out.print(inputArray[i][j]);		
					System.out.print(" ");					
				}
				System.out.println();				
			}			
		}
		else
		{
			if(checkCase(inputArray, size)==1)
			{
				for(int j=0; j<size; j++)
				{
					for(int i=size-1; i>=0; i--)
					{
						System.out.print(inputArray[i][j]);
						System.out.print(" ");
					}	
					System.out.println();
				}
			}
			if(checkCase(inputArray, size)==2)
			{	
				for(int j=size-1; j>=0; j--)
				{
					for(int i=size-1; i>=0; i--)
					{
						System.out.print(inputArray[j][i]);
						System.out.print(" ");
					}	
					System.out.println();
				}				
			}
			if(checkCase(inputArray, size)==3)
			{
				for(int j=size-1; j>=0; j--)
				{
					for(int i=0; i<size; i++)
					{
						System.out.print(inputArray[i][j]);
						System.out.print(" ");
					}	
					System.out.println();
				}				
			}			
		}	
	}	
	public static void main(String [] args)
	{
		Main obj = new Main();
		obj.run();
	}  	
	int checkCase(int[][] inputArray, int size)
	{
		int number = 0;
		if(inputArray[0][0]>=inputArray[size-1][0] && inputArray[0][0]<=inputArray[0][size-1])
			number = 1; //rotate 90 degrees to the left
		else if(inputArray[0][0]>=inputArray[size-1][0] && inputArray[0][0]>=inputArray[0][size-1] && inputArray[0][0]>=inputArray[size-1][size-1])
			number = 2; //rotate 180 degrees
		else if(inputArray[0][0]<=inputArray[size-1][0] && inputArray[0][0]>=inputArray[0][size-1])		
			number = 3; //rotate 270 degrees
		return number;
	}
	boolean isOriginal(int[][] inputArray, int size)
	{
		boolean good1 = false;
		boolean good2 = false;
		boolean good3 = false;
		boolean finalGood = false;
		if(inputArray[0][0]<= inputArray[0][size-1] && inputArray[0][0]<= inputArray[size-1][0] && inputArray[0][0]<= inputArray[size-1][size-1])
		{
			good1 = true;
		}
		if(inputArray[0][size-1]<=inputArray[size-1][size-1])
		{
			good2 = true;
		}
		if(inputArray[size-1][size-1]>=inputArray[0][0]&&inputArray[size-1][size-1]>=inputArray[size-1][0]&&inputArray[size-1][size-1]>=inputArray[0][size-1])
		{
			good3 = true;
		}
		if(good1)
		{
			if(good2)
			{
				if(good3)
				{
					finalGood = true;
				}
			}
		}
		else
		{
			finalGood = false;
		}
		return finalGood;
	}
}
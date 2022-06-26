/*
CCC '18 J3 - Are we there yet?

Notice that the result is a 5x5 symmetric matrix with 0 main diagonal.
Find prefix sum and add the symmetric position. Or take the transpose, then sum.

@author Vincent Zhang
@since 26 June 2022
@context Java Review
*/

import java.util.*;
import java.io.*;

public class AreWeThereYet_MatrixTranspose
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int E = data.length;
        int[][] mat = new int[E+1][E+1];

        // Find prefix sum.
        for(int i=0; i<E+1; i++)
            for(int j=i+1; j<E+1; j++)
                mat[i][j] = data[j-1] + mat[i][j-1];
            
        // Add symmetric position.
        for(int i=0; i<E+1; i++)
            for(int j=0; j<i; j++)
                mat[i][j] = mat[j][i];
        
        // Output result.
        for(int[] row: mat)
        {
            for(int col : row)
                System.out.print(col + " ");
            System.out.println();
        }
    
    }
}

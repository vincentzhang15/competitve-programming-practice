/*
CCC '18 J3 - Are we there yet?

Solution Logic:
 v
  3 10 12 5
   v
  3 10 12 5
  ...
           v
  3 10 12 5

  Insert pivot between each pair of numbers and compute prefix sum in either directions.

@author Vincent Zhang
@since 26 June 2022
@context Java Review
*/

import java.io.*;
import java.util.*;

public class AreWeThereYet_DoublePrefixSum
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int E = data.length;

        for(double i=-0.5; i<E; i++)
        {
            int idx_fwd = (int)Math.ceil(i)+1;
            int idx_rev = (int)Math.floor(i);
    
            int[] a = Arrays.copyOfRange(data, 0, idx_rev+1);
            int[] b = Arrays.copyOfRange(data, idx_fwd-1, E);
            int[] out = new int[a.length + 1 + b.length];
            for(int j=0; j<a.length; j++)
                out[j] = a[j];
            out[a.length] = 0;
            for(int j=a.length+1; j<a.length+1+b.length; j++)
                out[j] = b[j-a.length-1];

            
            for(int j=idx_fwd; j<E+1; j++)
                out[j] += j-1>=0 ? out[j-1] : 0;
            for(int j=idx_rev; j>-1; j--)
                out[j] += j+1<E ? out[j+1] : 0;
            
            for(int o : out)
                System.out.print(o + " ");
            System.out.println();

        }
    }
}

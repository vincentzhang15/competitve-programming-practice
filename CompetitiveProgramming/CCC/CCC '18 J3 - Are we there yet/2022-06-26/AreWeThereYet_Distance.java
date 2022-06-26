/*
CCC '18 J3 - Are we there yet?

Take inspiration from probability. P(X>=3)=1-P(P<3). Here, 3 represents index in prefix sum array and 1 represents value at last index of prefix sum array.
So distance from index 3 to end is simply value at end index - value at index 3.

@author Vincent Zhang
@since 26 June 2022
@context Java Review
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class AreWeThereYet_Distance
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dataIntArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=1; i<dataIntArr.length; i++)
            dataIntArr[i] += dataIntArr[i-1];
        
        int[] a = {0};
        int[] data = Arrays.copyOf(a, a.length + dataIntArr.length);
        System.arraycopy(dataIntArr, 0, data, a.length, dataIntArr.length);

        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
                System.out.print(Math.abs(data[j]-data[i]) + " ");
            System.out.println();
        }
    }
}

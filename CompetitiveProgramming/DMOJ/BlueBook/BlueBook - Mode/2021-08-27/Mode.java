/*
-------------------------------------------------------------------------
---------------------------- BlueBook - Mode ----------------------------
Find mode of a set of positive non-zero integers <= 100.

Sample Input
2
3
4
4
-1

Sample Output
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find max frequency, then sort all modes with the frequency.
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Finds the mode of a dataset.
 * @author Vincent Zhang
 * @since 27 August 2021
 */
public class Mode
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int[] freq = new int[103];
        int n;
        while((n=sc.nextInt()) != -1)
        {
            freq[n]++;
        }
        sc.close();

        int max = 0;
        for(int i=1; i<= 100; i++)
        {
            if(freq[i] > max)
                max = freq[i];
        }

        List<Integer> values = new ArrayList<>();
        for(int i=1; i<= 100; i++)
        {
            if(freq[i] == max)
                values.add(i);
        }
        Collections.sort(values);

        for(int i : values)
        {
            System.out.println(i);
        }

    }
}
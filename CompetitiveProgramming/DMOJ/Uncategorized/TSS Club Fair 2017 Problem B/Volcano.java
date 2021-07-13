/*
/////////////////////////////////////////////////////////////////////////////////
//////////////////////////// KEY CONCEPT TO REMEMBER ////////////////////////////
1. Squaring Int Or Long
    Resultant value will be determined by the variable type itself. Parameter variable type has no impact.
        long r = Long.parseLong(br.readLine());
        int idx = upperBound(houses, r*r);
    Rather than:
        int r = Integer.pareInt(br.readLine());
    
    Another example:
        long dx = Long.parseLong(line[0]);
        long dy = Long.parseLong(line[1]);
        houses[i] = dx*dx + dy*dy;
    If dx and dy are declared as ints, the products are ints.

2. upper_bound()
    static int upperBound(long[] houses, long val)
    {
        int lo = 0;
        int hi = houses.length-1;
        int index = houses.length;

        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            if(houses[mid] > val)
            {
                hi = mid - 1;
                index = mid;
            }
            else
                lo = mid + 1;
        }
        return index;
    }

//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// TSS Club Fair 2017 Problem B ////////////////////////////
When a volcano erupts, it destroys all houses (in the scope of this problem) within a circular radius.
Given the relative positions of houses to the volcano, determine the number of houses destroyed for various radii.

Sample Input
4 3
2 2
-4 0
0 -5
-5 -5
2
4
6

Sample Input Explanation:
Line 1: n q, number of houses, number of radii.
Line 2 to n+1: dx dy, relative coordinates from the volcano to the house.
Line n+1+1 to n+1+q: radius to find the number of houses within.

Sample Output
0
2
3

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Sort array that stores the square distance from a house to the volcano.
Find the upper bound for each radius squared in the house distance squared.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Program to find the number of coordinates in given radii.
 * @author Vincent Zhang
 * @since 12 July 2021
 */
public class Volcano
{
    /**
     * Method to find the binary search upper bound index.
     * @param houses The array to search in
     * @param val The value to search for
     * @return The index of the upper bound
     */
    static int upperBound(long[] houses, long val)
    {
        // lo hi are tracking indices.
        int lo = 0;
        int hi = houses.length-1;

        // Ensures the upper bound index. Default as the max possible upper bound, i.e., all houses destroyed by volcano.
        int index = houses.length;

        // Find the first value greater than val.
        while(lo <= hi)
        {
            // Equivalent to "(lo + hi) / 2 = (2lo + hi - lo)/2 = lo + (hi-lo)/2"
            int mid = lo + (hi - lo)/2;

            // Approach from above to find upper.
            if(houses[mid] > val)
            {
                hi = mid - 1;

                // Store intermediate index in case a further step does not produce the upper bound.
                index = mid;
            }
            // When value at search index is lower than desired value.
            else
                lo = mid + 1;
        }

        return index;
    }

    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @throws IOException BufferedReader exception
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);

        long[] houses = new long[n];
        for(int i=0; i<n; i++)
        {
            line = br.readLine().split(" ");
            long dx = Long.parseLong(line[0]);
            long dy = Long.parseLong(line[1]);

            // Store the squared distance from volcano to house.
            houses[i] = dx*dx + dy*dy;
        }
        // Sort for binary search upper bound.
        Arrays.sort(houses);

        for(int i=0; i<q; i++)
        {
            long r = Long.parseLong(br.readLine());
            int idx = upperBound(houses, r*r);
            
            // Index starts at 0, so upper bound index represents number of houses destroyed under current radius.
            System.out.println(idx);
        }
    }
}
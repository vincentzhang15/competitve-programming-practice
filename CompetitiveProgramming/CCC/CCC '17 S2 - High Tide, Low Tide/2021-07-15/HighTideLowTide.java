/*
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// CCC '17 S2 - High Tide, Low Tide ////////////////////////////
Order an unordered list of tide values according to rules:
    1. Tides alternate starting with low tide.
    2. High tides are always higher than low tides.
    3. High tides only increase. Low tides only decrease.

Sample Input
8
10 50 40 7 3 110 90 2

Sample Input Explanation
Line 1: number of tide measurements.
Line 2: unordered list of low and high tides.

Sample Output
10 40 7 50 3 90 2 110

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Sort initial unordered list of tides.
Since all high tides are greater than low tides, there must be a midpoint where the lower end is low tides and higher end is high tides.
Thus, split the sorted list in half, where the lower half corresponds to low tides (will contain 1 more value if number of tides is odd since low tides is the first number to be printed.)
High tides is the upper half.
After separating the low and high tides, print them in alternating order, starting with low tide.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Program to order an unordered list of low and high tide measurements. Note. ordering is not sorting in this context.
 * @author Vincent Zhang
 * @since 15 July 2021
 */
public class HighTideLowTide
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Get input and sort tides.
        int n = 0, tides[] = null;
        try
        {
            n = Integer.parseInt(br.readLine()); // Throws IOException or NumberFormatException.

            // Convert line into an integer array.
            tides = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // Throws IOException or NumberFormatException.

            br.close(); // Throws IOException.
        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        Arrays.sort(tides);

        // Split array.
        int mid = n-1 >> 1; // Bit shift has lower precedence than addition and subtraction.
        List<Integer> lo = new ArrayList<>();
        List<Integer> hi = new ArrayList<>();
        for(int i=mid; i>=0; i--) lo.add(tides[i]);
        for(int i=mid+1; i<n; i++) hi.add(tides[i]);

        // Output result.
        String output = "";
        for(int i=0; i<lo.size(); i++)
        {
            output += lo.get(i) + " ";
            if(i < hi.size()) output += hi.get(i) + " ";
        }
        System.out.println(output.trim()); // Remove extra space at end.
    }
}
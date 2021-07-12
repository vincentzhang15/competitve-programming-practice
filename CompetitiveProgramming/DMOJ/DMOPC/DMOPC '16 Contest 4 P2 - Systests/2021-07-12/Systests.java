/*
/////////////////////////////////////////////////////////////////////////////
//////////////////////////// JAVA SYNTAX SUMMARY ////////////////////////////
1. Java Binary Search: Alternative to lower_bound() in C++
    int lower = Arrays.binarySearch(fail, batch.a);
    // Arrays.binarySearch() returns index of search key if found else (-(insertion point) - 1).
    if(lower < 0)
        lower = -(lower+1);

///////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// DMOPC '16 Contest 4 P2 - Systests ////////////////////////////
Find the sum of valid points in list 1 given restrictions in list 2.
List 1: point and the interval the point is assigned to.
List 2: values. If a value is in an interval, the interval's points are invalid.

Sample Input:
3
1 5 100
20 21 10
1 18 1
2
2
5

Sample Input Explanation:
Line 1: n1, number of elements in list 1.
Line 2 to n1+1: a b p, the interval and point associated with that interval.s
Line n1+2: n2, number of elements in list 2.
Line n1+2+1 to n1+2+n2: values that devalues an interval, i.e., do not count the points in these intervals.

Sample Output
10

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Store both lists.
Sort the list of elements that devalues intervals.
Loop through every batch in list 1.
    Find the binary search insertion point of the left interval in list 2.
        Arrays.binarySearch() returns the index of the found value or (-(insertion point) - 1).
    Compare with conceptual result of upper bound. If any of the 2 conditions are satisfied, add points:
        1. Lower bound points (metaphorically) at the max value in the list.
        2. List 2 value at lower bound index > upper bound. This means the intervals don't intersect.
        Add valid points.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Class to store interval, and the point value for that interval.
 * @author Vincent Zhang
 * @since 12 July 2021
 */
class Data
{
    int a, b, p;
    /**
     * Initialize values upon instantiation.
     * @param a Lower bound
     * @param b Upper bound
     * @param p Point value
     */
    public Data(int a, int b, int p)
    {
        this.a = a;
        this.b = b;
        this.p = p;
    }
}

/**
 * Main class to solve the problem of finding the sum of the valid points.
 * @author Vincent Zhang
 * @since 12 July 2021
 */
public class Systests
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @throws IOException
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        // Create an instance of BufferedReader.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Store list 1 in an array of type Data.
        int nBatches = Integer.parseInt(br.readLine());
        Data[] batches = new Data[nBatches];
        for(int i=0; i<nBatches; i++)
        {
            String[] line = br.readLine().split(" ");
            batches[i] = new Data(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }

        // Store and sort list 2.
        int nFail = Integer.parseInt(br.readLine());
        int[] fail = new int[nFail];
        for(int i=0; i<nFail; i++)
            fail[i] = Integer.parseInt(br.readLine());
        Arrays.sort(fail);

        // Process: point calculation.
        int totalPoints = 0;
        // Loop through every interval and point value set to determine if points should be added.
        for(Data batch : batches)
        {
            int lower = Arrays.binarySearch(fail, batch.a);
            // Arrays.binarySearch() returns index of search key if found else (-(insertion point) - 1).
            if(lower < 0)
                lower = -(lower+1);

            // Compare with conceptual upper bound. See "SOLUTION LOGIC" in header for details.
            if(lower >= fail.length || fail[lower] > batch.b)
                totalPoints += batch.p;
        }

        // Output.
        System.out.println(totalPoints);
    }
}
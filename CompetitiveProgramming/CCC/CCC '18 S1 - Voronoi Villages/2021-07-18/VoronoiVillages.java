/*
#######################################################################################
############################ CCC '18 S1 - Voronoi Villages ############################
Villages are integer numbers along a road.
A point on the road is in the neighbourhood of a village it is closest to.
A point that is equally close to two villages are in both neighbourhoods.
A village on the endpoints of the road have infinite size neighbourhoods.
Find the neighbourhood with the minimum size (right bound - left bound).
Output neighbourhood size to 1 decimal place.

Restriction
Number of villages: N ϵ [3, 100].
Position of village on road: v_i ϵ [-1 000 000 000, 1 000 000 000].
All villages are at distinct positions.

Sample Input
5
16
0
10
4
15

Sample Input Explanation
Line 1: N, number of villages.
Line 2 to N+1: village position.

Sample Output
3.0

########################################################################
############################ SOLUTION LOGIC ############################
First sort the villages to arrange in the right order on the number line.
Find the midpoint between villages to get the neighbourhood boundary.
Find the difference between the midpoints to get the neighbourhood size.

Analysis of the sample input:
0     4     10     15     16     (Villages)
   2     7     12.5   15.5       (Midpoint)
      5    5.5      3            (Difference)

Thus, we find the smallest in the list of differences to be 3.0.

Expressing the average list in an equation, were v[i] is the village position:
a[i] = (v[i+1] + v[i]) / 2

Expressing the difference list in an equation:
d[i] = a[i+1]                - a[i]
     = (v[i+2] + v[i+1]) / 2 - (v[i+1] + v[i]) / 2
     = (v[i+2] + v[i+1] - v[i+1] - v[i]) / 2
     = (v[i+2] - v[i]) / 2

Thus, we can loop through the villages and find the minimum value of applying the equation above.
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

/**
 * Program to find the smallest neighbourhood.
 * @author Vincent Zhang
 * @since 18 July 2021
 */
public class VoronoiVillages
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        // Get villages.
        int[] v = new int[n]; for(int i=0; i<n; i++) v[i] = s.nextInt();
        s.close();
        Arrays.sort(v);

        // Calculate and output.
        Double[] d = new Double[n-2]; for(int i=0; i<n-2; i++) d[i] = (v[i+2] - v[i]) / 2.0;
        double min = Collections.min(Arrays.asList(d));
        System.out.printf("%.1f\n", min);
    }
}
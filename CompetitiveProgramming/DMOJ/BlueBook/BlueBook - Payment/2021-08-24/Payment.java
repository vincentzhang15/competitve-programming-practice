/*
----------------------------------------------------------------------------
---------------------------- BlueBook - Payment ----------------------------
Find the occurance frequency of integers (0 <= n <= 1000000) in each of the following ranges.
<= 9999
> 9999 && d <= 19999
> 19999 && d <= 29999
> 29999 && d <= 39999
> 39999 && d <= 49999
> 49999 && d <= 1000000

Output frequency count in order of the 6 intervals.
Line will be terminated by -1.

Sample Input
1
9999
10001
1000000
29999
-1

Sample Output
2
1
1
0
0
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Filter with a series of conditions.
*/

import java.util.Scanner;

/**
 * Counts occurance freqeuncy in 6 ranges.
 * @author Vincent Zhang
 * @since 24 August 2021
 */
public class Payment
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d, e, f;
        a = b = c = d = e = f = 0;

        while(true)
        {
            int n = sc.nextInt();
    
            if(n == -1) break;
            else if(n <= 9999) a++;
            else if(n <= 19999) b++;
            else if(n <= 29999) c++;
            else if(n <= 39999) d++;
            else if(n <= 49999) e++;
            else f++;
        }
        sc.close();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}
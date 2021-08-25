/*
---------------------------------------------------------------------------
---------------------------- BlueBook - Voting ----------------------------
Find the ballot count for candidates denoted by letters A-F.
Find the number of spoiled ballots.
First line of input will contain number of votes.

Sample Input
5
A
B
C
B
%

Sample Output
1
2
1
0
0
0
1

Sample Output Explanation
Lines 1-6: votes for candidate A-F.
Line 7: number of spoiled votes.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
An iterative approach might loop and cout.
Another method is to group the letters, store in a list of tupples (letter, frequency).
Then lookup the frequency for "A" to "F".

In both cases, spoiled ballots can be obtained from subtraction of valid ballots from total ballots.

*/

import java.util.Scanner;

/**
 * Counts ballots.
 * @author Vincent Zhang
 * @since 25 August 2021
 */
public class Voting
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
        a = b = c = d=e=f=0;

        int n = sc.nextInt();

        for(int i=0; i <n; i++)
        {
            String line = sc.next();
            switch(line.charAt(0))
            {
                case 'A': a++; break;
                case 'B': b++; break;
                case 'C': c++; break;
                case 'D': d++; break;
                case 'E': e++; break;
                case 'F': f++; break;
            }
        }
        sc.close();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(n-a-b-c-d-e-f);
    }
}
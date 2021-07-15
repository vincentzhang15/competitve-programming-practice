/*
////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// CCC '14 S3 - The Geneva Confection ////////////////////////////
Candies labelled 1 to "n" are dropped from the top of a mountain to a lake at the bottom of the mountain.
It is possible to slide a candy into a branch between the top and bottom of the bottom.
The branch operates in first in last out order.
Determine if it is possible to drop all candies to the lake such that they fall in an arithmetic progression where the common difference is 1.

Sample Input
2
4
2
3
1
4
4
4
1
3
2

Sample Input Explanation
Line 1: t, number of tasks (number of times to repeat the process of droping a group of candies).
Line 2: n[0], number of candies in task 1.
Line 3 to n[0]+2: candies in dropping order where Line n[0]+2 is the first candy to the dropped and Line 2 is the last.
Line n[0]+2+1: number of candies in task 2.
etc.

Sample Output
Y
N

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Store candies that go in the branch using a stack.
Track the candy number at the lake since candies must be in order 1, 2, 3, ... , n.

Two actions for every candy:
    1. If can be dropped to lake, drop. Then drop any candy in branch where possible.
    2. Add to branch if cannot be dropped.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

/**
 * Determine if a list of numbers from 1 to n can be sorted using a stack.
 * @author Vincent Zhang
 * @since 15 July 2021
 */
public class TheGenevaConfection
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @throws IOException BufferedReader's exception
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nT = Integer.parseInt(br.readLine());
        for(int t=0; t<nT; t++)
        {
            // Get input.
            int nCandy = Integer.parseInt(br.readLine());
            int[] candies = new int[nCandy]; for(int i=0; i<nCandy; i++) candies[i] = Integer.parseInt(br.readLine());

            // Important variables.
            int lake = 0;
            Stack<Integer> branch = new Stack<>();

            // Loop through candies: drop to lake or store in branch.
            for(int i=nCandy-1; i>=0; i--)
            {
                int candy = candies[i];

                // If drop is possible, also check if any candies in branch can be dropped.
                if(candy == lake+1)
                {
                    lake++;

                    while(!branch.isEmpty() && branch.peek() == lake+1)
                    {
                        branch.pop();
                        lake++;
                    }
                }
                // Add to branch since candies cannot be dropped.
                else
                    branch.push(candy);
            }

            // Since valid candies have already been dropped, any candy remaining in the stack are not in the right order.
            System.out.println(branch.isEmpty() ? "Y" : "N");

        }
    }
}
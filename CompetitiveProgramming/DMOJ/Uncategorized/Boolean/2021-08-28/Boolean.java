/*
-----------------------------------------------------------------
---------------------------- Boolean ----------------------------
Evaluate a boolean expression.

Sample Input 1
not not True

Sample Output 1
True

Sample Input 2
not not not False

Sample Output 2
True

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Count the number of "not". Even number will cancel out. Only need to apply one negation if odd.
Another way is to XOR while taking input, and compare initial assumed value with final True/False.
*/

import java.util.Scanner;

/**
 * Evaluates a boolean expression.
 * @author Vincent Zhang
 * @since 28 August 2021
 */
public class Boolean
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(true)
        {
            String word = sc.next();

            if(word.equals("not"))
            {
                count++;
            }
            else
            {
                if(count % 2 == 0)
                    System.out.println(word);
                else
                {
                    if(word.equals("False"))
                        System.out.println("True");
                    else
                        System.out.println("False");
                }
                break;
            }
    
        }
        sc.close();

    }
}
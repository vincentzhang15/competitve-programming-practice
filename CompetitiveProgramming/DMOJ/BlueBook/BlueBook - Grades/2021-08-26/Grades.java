/*
---------------------------------------------------------------------------
---------------------------- BlueBook - Grades ----------------------------
Determine the grade letter given an integer that is an element of (-1000, 1000)
    "
    A 	80 - 100
    B 	70 - 79
    C 	60 - 69
    D 	50 - 59
    F 	0 - 49
    X 	Anything else…
    "

Sample Input
3
10
99
101

Sample Output
F
A
X

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
If statements.
*/

import java.util.Scanner;

/**
 * Find the grade leter of a grade value.
 * @author Vincent Zhang
 * @since 26 August 2021
 */
public class Grades
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++)
        {
            int x = sc.nextInt();
            if(x >= 80 && x <= 100)
                System.out.println("A");
            else if(x >= 70 && x <= 79)
                System.out.println("B");
            else if(x >= 60 && x <= 69)
                System.out.println("C");
            else if(x >= 50 && x <= 59)
                System.out.println("D");
            else if(x >= 0 && x <= 49)
                System.out.println("F");
            else
                System.out.println("X");
        }
        sc.close();
    }
}
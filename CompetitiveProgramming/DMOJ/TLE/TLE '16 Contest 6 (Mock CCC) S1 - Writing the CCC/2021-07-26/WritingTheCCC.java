/*
###########################################################################################################
############################ TLE '16 Contest 6 (Mock CCC) S1 - Writing the CCC ############################
"The CS Nerd" solves problems in order of preference by problem type.
Input will first give a list of question prefernces in order.
The second part of the input will give the order of question types on the CCC (Canadian Chemistry Competition).
Output the order in which "the CS nerd" solves the problems according to the order of preference.

Sample Input
5
equilibrium
trivial
organic
lab
adhoc
7
trivial
organic
adhoc
equilibrium
trivial
lab
adhoc

Sample Input Explanation
L1: t, number of problem types.
L2 to Lt+1: problem types in order of preference.
Lt+1+1: n, number of questions on the CCC.
Lt+1+1 to Lt+1+n: questions types on the CCC in order that it appears on the contest.

Sample Output
4
1
5
2
6
3
7

########################################################################
############################ SOLUTION LOGIC ############################
Store prefernce order in a list/array to process later.
For fast output of order, a dict/map can be used in which the reference to the map would lead to the positions of all occurances of a problem type.
    dict = {type, [occurance position1, pos2, ...]}
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Program to find the order of problem completion of a chemistry contest.
 * @author Vincent Zhang
 * @since 26 July 2021
 */
public class WritingTheCCC
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        // Store order of preference and initialize order of questions.
        int t = nextInt();
        String[] order = new String[t];
        Map<String, List<Integer>> data = new HashMap<>();
        for(int i=0; i<t; i++)
        {
            String choice = nextLine();
            order[i] = choice;
            data.put(choice, new ArrayList<>());
        }

        // Store order of questions.
        int n = nextInt();
        for(int i=0; i<n; i++)
        {
            String choice = nextLine();
            data.get(choice).add(i+1);
        }

        // Output results.
        for(int i=0; i<t; i++)
        {
            for(int pos : data.get(order[i]))
            {
                System.out.println(pos);
            }
        }
    }

    /**
     * Obtain the next line of input data as string.
     * @return The string value of the next line of input
     */
    static String nextLine()
    {
        String s = "";
        try {
            s = br.readLine();
        } catch(IOException e) {e.printStackTrace();}
        return s;
    }

    /**
     * Obtain the integer value of the next input line.
     * @return Integer value of the next line
     */
    static int nextInt()
    {
        int n = -1;
        try {
            n = Integer.parseInt(nextLine());
        } catch(NumberFormatException e) {e.printStackTrace();}
        return n;
    }
}
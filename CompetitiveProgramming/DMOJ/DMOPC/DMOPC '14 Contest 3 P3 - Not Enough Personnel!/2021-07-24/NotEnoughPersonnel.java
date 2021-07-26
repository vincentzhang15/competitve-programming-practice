/*
########################################################################################################
############################ DMOPC '14 Contest 3 P3 - Not Enough Personnel! ############################
A business is hiring new employees who will learn alongside a veteran employee.
Each new employee has a skill and adaptability value.
A veteran must be at least the same skill level as a new employee and at most the same skill level + adaptability value.
If multiple veterans qualify, then the one with the closest value should be chosen. Break any additional ties with inupt order.
If there are no matches then output "No suitable teacher!".

Sample Input 1
5
Kanie 1000
Moffle 800
Sento 950
Macaron 550
Tirami 500
3
930 20
400 150
790 15

Sample Input 1 Explanation
Line 1: n, number of veterans.
Line 2 to n+1: veteran name and skill level.
Line n+1+1, q, number of new employees.
Line n+1+1+1 to n+1+1+q: skill level and adaptability of new employees.

Sample Output 1
Sento
Tirami
Moffle

Sample Input 2
4
Muse 203
Sylphy 202
Koboli 202
Salama 999
2
200 1
200 3

Sample Output 2
No suitable teacher!
Sylphy

########################################################################
############################ SOLUTION LOGIC ############################
Store the veterans name and skill in a 2d list or two 1d lists as sorting is not required so order is preserved.
Loop through every new employee and find the veteran with the closest skill level
by checking if skill is within range and if skill differance is less than the existing difference.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Program to match veteran employees with new employees.
 * @author Vincent Zhang
 * @since 24 July 2021
 */
public class NotEnoughPersonnel
{
    // Global declarations.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    /**
     * Main method to solve the problem.
     * @return void
     */
    void run()
    {
        // Store veteran employee names and skills.
        int n = nextInt();
        String[] names = new String[n];
        int[] skills = new int[n];
        for(int i=0; i<n; i++)
        {
            names[i] = nextToken();
            skills[i] = nextInt();
        }

        // Process each new employee.
        int q = nextInt();
        for(int i=0; i<q; i++)
        {
            int skill = nextInt();
            int adapt = nextInt();
            int dist = Integer.MAX_VALUE;
            String name = "";

            // Find the best match in the veterans by seraching for first veteran with closest skill level within the boundary.
            for(int j=0; j<n; j++)
            {
                if(skills[j] >= skill && skills[j] <= skill + adapt && skills[j] - skill < dist)
                {
                    dist = skills[j] - skill;
                    name = names[j];
                }
            }

            // If no one is within the boundary.
            if(name.length() == 0)
                System.out.println("No suitable teacher!");
            else
                System.out.println(name);
        }


    }

    /**
     * Obtain the next token in the line of input.
     * @return The next token in the input string
     */
    String nextToken()
    {
        while(st == null || !st.hasMoreTokens())
        {
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {e.printStackTrace();}
        }
        return st.nextToken();
    }

    /**
     * Attempt to convert nextToken() to integer.
     * @return The integer value of the next token.
     */
    int nextInt()
    {
        int n = -1;
        try {
            n = Integer.parseInt(nextToken());
        } catch(NumberFormatException e) {e.printStackTrace();}
        return n;
    }

    /**
     * Instantiate NotEnoughPersonnel to reference from non-static context.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        NotEnoughPersonnel nep = new NotEnoughPersonnel();
        nep.run();
    }
}
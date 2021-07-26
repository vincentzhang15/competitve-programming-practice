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

/**
 * Program to match new employees with veteran employees.
 * @author Vincent Zhang
 * @since 24 July 2021
 */
#include <iostream>

/**
 * Main fundtion to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    // Store veteran name and skills in two 1D arrays.
    int n; std::cin >> n;
    std::string names[n];
    int skills[n];
    for(int i=0; i<n; i++)
    {
        std::cin >> names[i];
        std::cin >> skills[i];
    }

    // Process each new employee individually.
    int q; std::cin >> q;
    for(int i=0; i<q; i++)
    {
        int skill, adapt; std::cin >> skill >> adapt;
        std::string name = "";
        int dist = 0x3f3f3f3f;

        // Find the first veteran closest to the new employee's skill level.
        for(int j=0; j<n; j++)
        {
            if(skills[j] >= skill && skills[j] <= skill + adapt && skills[j] - skill < dist)
            {
                dist = skills[j] - skill;
                name = names[j];
            }
        }

        // If there are no matches.
        if(name.length() == 0)
            std::cout << "No suitable teacher!" << '\n';
        else
            std::cout << name << '\n';
    }
    
    return 0;
}
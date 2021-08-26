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

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Find the grade leter of a grade value.
@author Vincent Zhang
@since 26 August 2021
*/

#include <iostream>

int n, x;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> n;
    while(n--)
    {
        std::cin >> x;
        if(x >= 80 && x <= 100)
            std::cout << "A";
        else if(x >= 70 && x <= 79)
            std::cout << "B";
        else if(x >= 60 && x <= 69)
            std::cout << "C";
        else if(x >= 50 && x <= 59)
            std::cout << "D";
        else if(x >= 0 && x <= 49)
            std::cout << "F";
        else
            std::cout << "X";
        std::cout << "\n";
    }

    return 0;
}
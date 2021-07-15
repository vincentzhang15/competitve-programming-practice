/*
///////////////////////////////////////////////////////////////////////
//////////////////////////// SYNTAX ERRORS ////////////////////////////
1. Concatenating Characters
    The following code:
        s = s[1] + s[0] + s.substr(2);
    Causes this syntax error:
        error: no match for 'operator+' (operand types are 'int' and 'std::__cxx11::basic_string<char>')
    Because using the "+" operator on characters result in an integer.
    
    Solution:
        s = std::string(1, s[1]) + std::string(1, s[0]) + s.substr(2);
    s = string(n, c) copies character "c" "n" times into "s".
    
2. Concatenating Integers and Strings
    This code:
        std::cout << ">>" << 2 + " " + 4 << "<<" << std::endl;
    Outputs:
        >>BCDE<<
    Leading to confusion as to where these characters came from.
    
    Solution - convert int to string:
        std::cout << ">>" << std::to_string(2) + " " + std::to_string(4) << "<<" << std::endl;
    Which outputs:
        >>2 4<<

///////////////////////////////////////////////////////////////////////////////
//////////////////////////// NEWLY LEARNT CONCEPTS ////////////////////////////
1. Fast Input "Side Effect"
    https://stackoverflow.com/questions/31162367/significance-of-ios-basesync-with-stdiofalse-cin-tienull
    std::ios_base::sync_with_stdio(false);
        Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::cin.tie(nullptr);
        Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    Flushing may be needed when using std::cin.tie(nullptr);

2. \n versus std::endl
    https://stackoverflow.com/questions/213907/stdendl-vs-n

    There is no difference in "text mode" but is different in binary.
    "std::endl flushes the output buffer, and '\n' doesn't"

    "
        std::cout << std::endl;
    is equivalent to
        std::cout << '\n' << std::flush;
    ""

3. C/C++ return 0 in main()
    https://stackoverflow.com/questions/204476/what-should-main-return-in-c-and-c
    "
    Normal exit is represented by a 0 return value from main.
    Abnormal exit is signaled by a non-zero return, but there is no standard for how non-zero codes are interpreted.
    void main() is prohibited by C++ standard." Don't use.

    Valid C++ main signatures:
        1.
            --> int main()
        2. Both signatures are equivalent.
            --> int main(int argc, char *argv[])
            --> int main(int argc, char **argv)

4. char* argv[] and char** argv
    https://stackoverflow.com/questions/5192068/c-char-argv-vs-char-argv
    https://stackoverflow.com/questions/4208444/c-difference-between-and

    They are equivalent ONLY in function signatures.
    char *argv[]: array of pointers to char.
    char **argv: pointer to pointer to char.
        (Array argument demoted to a pointer).
            "
            It's a language rule.
            When you declare or define a function with the syntax X foo(Y a[]),
                                        then it actually becomes X foo(Y *a).
            What looks like an array argument to a function is really a pointer.
            Since argv is declared as an array (of pointers), it becomes a pointer (to pointers).

5. C++ Command-Line Arguments
    https://stackoverflow.com/questions/3024197/what-does-int-argc-char-argv-mean
    int main(int argc, char *argv[])
    argc (argument count):
        "number of strings pointed to by argv".
        "1 plus the number of arguments as virtually all implementations prepend the name of the program to the array"
    argv (argument vector):
        The actual command-line arguments.
    
    Example:
    Code:
        for (int i = 0; i < argc; ++i)
            std::cout << argv[i] << std::endl;
    Run:
        ./test a1 b2 c3
    Output:
        ./test
        a1
        b2
        c3

/////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// CCC '08 J2 - Do the Shuffle ////////////////////////////
A music player has 5 songs "ABCDE" starting in that order.
The music player has 4 buttons:
    Button 1: move first song to end.
    Button 2: move last song to start.
    Button 3: swap first two songs.
    Button 4: output playlist in order and quit program.
Additionally, a button "b" is pressed "n" number of times.
b ϵ [1, 4]
n ϵ [1, 10]

Sample Input
2
1
3
1
2
3
4
1

Sample Input Explanation
Line 2k-1, k ϵ N: b, button that is pressed.
Line 2k  , k ϵ N: n, number of times button "b" is pressed.

Sample Output
B C D A E

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Direct implementation:
    Store songs in a string.
    Change string when b = [1, 3].
    Output and quit when b = 4.
*/

/**
 * Program to track a playlist in a music player.
 * @author Vincent Zhang
 * @since 15 July 2021
 */
#include <iostream>

/**
 * Main method to solve the problem.
 * @param argc Argument count
 * @param argv Argument vector, program name and command-line arguments
 * @return 0
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    std::cin.tie(nullptr);

    std::string s = "ABCDE";
    const int SONGS = 5;

    while(1)
    {
        int b, n; std::cin >> b >> n;

        // First to end.
        if(b == 1)
            for(int i=0; i<n%SONGS; i++)
                s = s.substr(1) + s[0];
        // Last to start.
        if(b == 2)
            for(int i=0; i<n%SONGS; i++)
                s = s[s.length()-1] + s.substr(0, s.length()-1);
        // Swap first two.
        if(b == 3)
            if(n % 2 == 1)
                // Ensure char is converted to string.
                s = std::string(1, s[1]) + std::string(1, s[0]) + s.substr(2);
        
        // Print.
        if(b == 4)
        {
            for(size_t i=0; i<s.length()-1; i++)
                std::cout << s[i] << " ";
            std::cout << s[s.length()-1] << '\n';
            break;
        }
    }

    // Normal exist will return 0.
    return 0;
}
/*
///////////////////////////////////////////////////////////////////////////////////
//////////////////////////// C++ UNRESOLVED CONFUSIONS ////////////////////////////
1. __int128 Comparison With int
    cout << (18446744073709551480 == -136) << endl; // 0. Why?
    Casting both values to int, unsigned int, size_t all yield the same value.
    Speculation: some casting with the == operator?

2. Printing Out of Bounds of a String
    Printing out of bounds of a string produces characters such as '♥' and 'É'. Where are these chars from?
    Speculation: maybe this is what Undefined Behaviour means?

////////////////////////////////////////////////////////////////////////////
//////////////////////////// C++ SYNTAX SUMMARY ////////////////////////////
1. try{}catch(){}
    https://www.geeksforgeeks.org/stdbasic_stringat/

    std::string str = "abc";
    try {
        str.at(4) = 't';
    } catch (std::out_of_range const& error) {
        std::cout << error.what() << '\n';
    }

/////////////////////////////////////////////////////////////////////////
//////////////////////////// C++ DISCOVERIES ////////////////////////////
0. Memorize
    --> Existance of:
        -->          __int128: signed 128-bit integer
        --> unsigned __int128: unsigned 128-bit integer
    --> Emphasize:
        --> size_t always >= 0 because negative numbers wrap to upper bound of size_t  ϵ [0, 18446744073709551615].
        --> the nature of for loops: loops only while condition is true.
    --> string::length returns size_t
    --> Undefined Behaviour (UB)
        --> Undefined Behaviour "is the result of executing a program whose behavior is prescribed to be unpredictable, in the language specification to which the computer code adheres."
        --> "memory accesses outside of array bounds" or "Buffer Overflow", is a type of undefined behaviour in C++.
        --> There is no bound checking on arrays and strings with the [] operator for efficiency.
            --> One of C++'s guiding principles is "you don't pay for what you don't use". Since correct code does not require bound checking, it is unecessary.
            --> Class types can have bound checking. To bound check on string or vector, use the member function at().

1. C++ Data Types
    Note: type_name<decltype(i)>() functionality is achieved using Howard Hinnant's response in:
    https://stackoverflow.com/questions/81870/is-it-possible-to-print-a-variables-type-in-standard-c

    cout << type_name<decltype(18446744073709551480)>() << endl; // __int128
    cout << type_name<decltype(-136)>() << endl; // int

    cout << (18446744073709551480 == -136) << endl; // 0. Why?
    // cout << (__int128)18446744073709551480 << endl; // error: ambiguous overload for 'operator<<' (operand types are 'std::ostream' {aka 'std::basic_ostream<char>'} and '__int128')
    cout << (int)18446744073709551480 << endl; // -136
    cout << (int)-136 << endl; // -136
    cout << (unsigned int)18446744073709551480 << endl; // 4294967160
    cout << (unsigned int)-136 << endl; // 4294967160
    cout << (size_t)18446744073709551480 << endl; // 18446744073709551480
    cout << (size_t)-136 << endl; // 18446744073709551480

2. __int128
    https://codeforces.com/blog/entry/75044
    https://gcc.gnu.org/onlinedocs/gcc/_005f_005fint128.html
    __int128 is a 128 bit integer.
    It is "an extension the integer scalar type"
    "__int128 for a signed 128-bit integer, or unsigned __int128 for an unsigned 128-bit integer"
    KEY TAKEAWAY ========
    --> Existance of:
        -->          __int128: signed 128-bit integer
        --> unsigned __int128: unsigned 128-bit integer

3. Infinite Loop With size_t
    for(size_t i = 0; i>= 0; i--)
    size_t is unsigned and wraps to 2^64-1 at -1. It will never become negative.

4. Loop Does Not Work With size_t Because size_t ϵ [0, 18446744073709551615] And size_t Wraps Value At -1.
    int lastIndexOf(string s, char c)
    {
        for(size_t i = s.length()-1; i >= 0; i--)
            if(s[i] == c)
                return i;
        return -1;
    }

    Within the scope of this problem, lastIndexOf(string, char) is called:
        1. If last character of the 'string' is '0'.
        2. 'char' is always '1'

    Discovery Progression
    1. Call lastIndexOf("0", "1") results wrong answer to problem.
        print: i, in for loop.
        output: 18446744073709551615
                18446744073709551614
                ...
                18446744073709551481
                18446744073709551480
    2. research: significance of 18446744073709551615
        https://stackoverflow.com/questions/40608111/why-is-18446744073709551615-1-true
        -1 (DEC)
        0000000000000000000000000000000000000000000000000000000000000001b (+1 BIN)
        1111111111111111111111111111111111111111111111111111111111111110b (-1 OCP - One's complement)
        +                                                               1b (1 BIN)
        = 1111111111111111111111111111111111111111111111111111111111111111b (-1 TCP - Two's complement)

        = 1111111111111111111111111111111111111111111111111111111111111111b
        = 2^64 − 1
        18,446,744,073,709,551,615

        18446744073709551615 == -1:
            comparing unsigned 64bit int to signed 64bit int
    3. observations:
        Countdown from 2^64 -1 occurs when input string is ("s" was assigned these values in the function during testing, unrelated to stdin):
            "0"
            "2"
            "3"
        Does not occur when input string is:
            "1"

        print: size_t test = -1;
        output: 18446744073709551615
        print: size_t test = -2:
        output: 18446744073709551614
        implication: reverse countdown from 2^64-1 occured because -1 was assigned to "size_t i" in the loop.
        confusion: why does "0" lead to negative index while "1" doesn't when index is assigned by string length?
        realization: because the loop break condition is when the char is '1' based on the function call. Calls always occur for finding '1' in this problem.
        implication: the loop breaks when string is "1" while when string is "0", "2", etc, breaking doesn't occur.
            implication: may be problems in for loop condition statement.
        test: remove return condition in loop.
            result: infinite loop.
            realization: size_t never < 0 and the condition is while size_t >= 0, it will always be true.
            implication: size_t ϵ [0, 18446744073709551615]. Stop loop in two ways:
                1. Loop never starts. (When condition is unsatisfied at loop entry. Impossible with size_t and >= 0 condition.)
                2. Loop ends at 1. (Using only size_t with no int workarounds)
    KEY TAKEAWAY ========
        --> Emphasize:
            --> size_t always >= 0 because negative numbers wrap to upper bound of size_t.
            --> the nature of for loops: loops only while condition is true.
    4. Test Possible End Condition With Only size_t
        test: add "i <= s.length()-2" to for loop condition, since 18446744073709551615 > (int)("0".length()-2)
        result: loop continues at size_t = -1.
        print: s.length()-2, when s = "0".
        output: 18446744073709551615
        research: string::length return size_t
            implication: the only way to stop size_t reverse loop without using int workarounds is stop loop at 1.
    KEY TAKEAWAY ========
        --> string::length returns size_t

5. C++ Undefined Behaviour (UB)
    Discovery Progression
    1. recall: size_t i = 18446744073709551615. This index was used to check s[i] for '1'.
        confusion: why "0"[2^64-1] does not throw out of bound exception?
            print: ">>" + "0"[18446744073709551615] + "<<"
            output: ">> <<"
        research: string index out of bound no exception in C++.
            https://stackoverflow.com/questions/1239938/accessing-an-array-out-of-bounds-gives-no-error-why
            Common C++ UB:
            https://stackoverflow.com/questions/367633/what-are-all-the-common-undefined-behaviours-that-a-c-programmer-should-know-a
            
            Reading beyond size of object (string) is a "Buffer Overflow", which is a type of Undefined Behaviour in C++.
            Why no bound checking on array?
                1. "array is a leftover from C". Array: "a sequence of elements with contiguous addresses"
                    (string class contains char[])
                    Why no bound checking using array?
                        1. bound checking is "simply exposing raw memory"
                        2. "robust bounds-checking mechanism almost impossible in C"
                2. "bounds-checking is possible on class types but array is the C-compatible one" array not class
                3. "C++ [built on] guiding principle: 'you don't pay for what you don't use' "
                    --> Correct code no need bound check.
                        --> Bound check cause overhead in runtime.
                4. "std::vector class template allows" bound checking and no bound checking.
                    --> "operator[] is designed to be efficient"
                    --> vector's "at() member function" bound checks.
                        --> vector has "array-like performance without bounds-checking"
                        --> vector has "ability to use bounds-checked access"
                        --> (string also has at() member function that performs bound check)
            Note: reading out of bound throws no exception. Writing to out of bound causes segmentation fault.
    KEY TAKEAWAY ========
    https://en.wikipedia.org/wiki/Undefined_behavior
    https://en.cppreference.com/w/cpp/language/ub
    --> Undefined Behaviour "is the result of executing a program whose behavior is prescribed to be unpredictable, in the language specification to which the computer code adheres."
        --> "memory accesses outside of array bounds" or "Buffer Overflow", is a type of undefined behaviour in C++.
        --> There is no bound checking on arrays and strings with the [] operator for efficiency.
            --> One of C++'s guiding principles is "you don't pay for what you don't use". Since correct code does not require bound checking, it is unecessary.
            --> Class types can have bound checking. To bound check on string or vector, use the member function at().
6. String Out of Bound Characters
    confusion: since "0"[2^64-1] does not throw an out of bound exception, what does it return?
    tests:
        test1:
            int count = 0;
            for(size_t i = 0; ; i--)
            {
                count ++;
                cout << ">>" << "0"[i] << "<< " << count << endl;
            }
        output:
            ...
            >>♥<< 16548
            >> << 16549
            >>É<< 16550
            >>Z<< 16551
            >>M<< 16552
            >>
        
        test2:
            cout << ">>" << "1"[i] << "<< " << count << endl;
        output:
            ...
            >>♥<< 16548
            >> << 16549
            >>É<< 16550
            >>Z<< 16551
            >>M<< 16552
            >>
        
        test3:
            print: "aTY#43&*{}"[i]
        output:
            ...
            >>♥<< 16548
            >> << 16549
            >>É<< 16550
            >>Z<< 16551
            >>M<< 16552
            >>
        
        test4:
            cout << ">>" << "0"[16552] << "<<" << endl;
        output:
            >> <<
        
        test5:
            cout << ">>" << "aTY#43&*{}"[i] << "<< " << count << endl;
            cout << "<<" << "0"[16552] << ">>" << endl;
        output:
            ...
            >>♥<< 16551
            << >>
            >> << 16552
            << >>
            >>É<< 16553
            << >>
            >>Z<< 16554
            << >>
            >>M<< 16555
            << >>
            >>
        observation:
            ♥ at 16548 --> 16551
        
    tests observation:
        ♥ is not ASCII, can be chcp 65001 or Unicode character.
    tests confusion
        Where do these characters come from?
    KEY CONFUSION
    --> Printing out of bounds of a string produces characters such as '♥' and 'É'. Where are these chars from?

///////////////////////////////////////////////////////////////////////////
//////////////////////////// Flip the Switches ////////////////////////////
A security system is controlled by "n" switches and for every switch, 0 is off and 1 is on.
A security system is turned off when all switches are 0.
You can only flip the first "k" switches, where "k" is a value you choose [1, n].
Find the minimum number of flips to turn off the security system.

Sample Input
4
1001

Sample Input Explanation
Line 1: number of switches, i.e., number of characters in the next string.
Line 2: string of switch states.

Sample Output
3

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Count the number of changes between 0 and 1 by counting the number of groups of 0s and 1s.
    Can be done with regular expression.
        Ensure trailling 0s are removed in this method as they count as an additional flip by regex match when no flip is necessary.

Remove trailing 0s by finding the last index of 1 and taking the substring if 1s exist.

Additional Realization:
    for(int i = s.length()-1; i >= 0; i--)
    Line above refers to reverse loop through a string to find the last index of a character in the string.
    Within the scope of this problem, starting check at s.length()-1 is unecessary as the last character of the string has already been checked for '0' before calling this lastIndexOf() function.
    For this question, checking should start at s.length()-2.
    However, for correctness of the lastIndexOf() function, counting should start from s.length()-1.
*/

/**
 * Program determines the minimum number of flips to turn off a security system.
 * @author Vincent Zhang
 * @since 13 July 2021
 */
#include <iostream>
#include <regex>
using namespace std;

/**
 * Method to find the last index of a character from the given string.
 * @param s The string to find the character in
 * @param c The character to search for in the string
 * @return The index of the last occurance of the character in the string, -1 if "c" does not exist in "s"
 */
int lastIndexOf(string s, char c)
{
    // Loop through the string backwards and return the first matching index.
    for(size_t i = s.length()-1; i >= 0; i--)
        // Catch out of range exception that .at() throws when size_t wraps to 2^64-1.
        try
        {
            if(s.at(i) == c)
                return i;
        }
        catch(out_of_range const& error)
        {
            break;
        }

    // If no index is found, return -1.
    return -1;
}

int main()
{
    // Fast input.
    cin.sync_with_stdio(0);
    cin.tie(0);

    // Number of switches is not useful for this approach.
    int n; cin >> n;

    // Get switch states and remove trailling zeroes if they exist.
    string s; cin >> s;
    if(s[s.length()-1] == '0')
    {
        int index = lastIndexOf(s, '1');
        s = s.substr(0, index+1);
    }

    // Count groups of 0s and 1s by matching with regular expression.
    regex const pattern("0+|1+");
    ptrdiff_t const matches
    (
        distance
        (
            sregex_iterator(s.begin(), s.end(), pattern),
            sregex_iterator()
        )
    );

    // Output.
    cout << matches << '\n';

    return 0;
}
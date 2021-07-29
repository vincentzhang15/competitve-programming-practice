{-
--------------------------------------------------------------------------------
---------------------------- HASKELL SYNTAX SUMMARY ----------------------------
main = getLine >>= \s -> putStrLn $ [ (['a'..'z'] \\ s ) !! 0]
    1. ['a'..'z']
        Creates list of lowercase alphabet characters.
    2. s
        Value of getLine.
    3. list !! 0
        Value at index 0 of list.
    4. \\
        Haskell lists difference.
        https://stackoverflow.com/questions/4573692/haskell-lists-difference
        "
            e.g.,
                >>> import Data.List
                >>> [1,2,3] \\ [1,2]
                [3]
        "
    5. >>= and >>
        https://stackoverflow.com/questions/23094009/why-is-bind-written-as-in-haskell-monads/23094127
        "
            m >>= k suggests "feed the result of computation m to the function k";
            m >> n suggests "run the m computation and then the n computation".
        "
    6. \variable
        https://stackoverflow.com/questions/26988232/use-of-backslashes-with-variables-in-haskell
        "
            2 Lines below are equivalent
                f = \x -> <thing>
                f x = <thing>

            Lines below are equivalent
                voltea = (\f -> (\x -> (\y -> f y x)))
                voltea f = (\x -> (\y -> f y x))
                voltea f x = \y -> f y x
                voltea f x y = f y x
        "

#################################################################################################
############################ CPC '21 Contest 1 P0 - AQT and Alphabet ############################
Find the first letter of the lowercase alphabet not in the input string.
The only line of input string will always contain 5 characters.

Sample Input
zdeac

Sample Input Explanation
L1: 5 characters of the lowercase alphabet.

Sample Output
b

########################################################################
############################ SOLUTION LOGIC ############################
In general, compare input string against alphabet.
Optimization: only first 6 letters of alphabet need to be checked since there are always 5 letters in input string.

Method 1 - Implemented using Haskell in Alphabet.hs:
    Subtract the input string from the lowercase alphabet and output the first character of the result.
Method 2 - Implemented using Python 3 in Alphabet.py:
    Construct a list of lowercase alpha characters not in input string, then output first element in list.
Method 3 - Implemented using C++ in Alphabet.cpp:
    Record occurance of each input string character in an array of length 26, then output the first element without a record.
Method 4 - Implemented using Java in Alphabet.java:
    Loop through integer value of alphabet and check if integer value exists in an array of integer value of the input string (char[]).
Method 5 - Implemented using C in Alphabet.c:
    Loop through characters of alphabet and check if character exists in input string.

#########################################################################
############################ MODULE COMMENTS ############################
Program to find the first lowercase alpha character not in a given string.
@author Vincent Zhang
@since 28 July 2021
@context Self-Learning Haskell
-}

-- Data.List for difference operator \\.
import Data.List

-- Subtract input string from alphabet list.
main = getLine >>= \s -> putStrLn $ [ (['a'..'z'] \\ s ) !! 0]
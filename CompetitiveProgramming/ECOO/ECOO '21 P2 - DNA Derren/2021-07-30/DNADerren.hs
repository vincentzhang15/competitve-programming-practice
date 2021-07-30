{-
----------------------------------------------------------------------------------
---------------------------- ECOO '21 P2 - DNA Derren ----------------------------
Given a DNA genome sequence (string composed of 'A' 'C' 'T' 'G' characters),
output the order such that vowel and consonant alternate.
Add a space if two adjacent letters are both consonants/vowels.

Sample Input 1
ACTGAGCA

Sample Output 1
AC T GAG CA

Sample Input 2
AAAAGCGCTA

Sample Output 2
A A A AG C G C TA

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop through the string and process a pair of characters each time.

Loop through string:
    Method 1:
        Use for loop from 0 to DNA genome sequence length-1.
        Note: add an extra space at the end of input string to allow the last char to be processed without adding endpoint case.
    Method 2 (for Haskell):
        Recursive call and remove a character each time.

Processing pair characters:
    Method 1: output directly.
    Method 2: store data to char list/list/array. (See DNADerren.hs .py .c).

-------------------------------------------------------------------------
---------------------------- MODULE COMMENTS ----------------------------
Program to space out a DNA genome sequence.
@author Vincent Zhang
@since 30 July 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Function to build the output string that contains the sequence spaced out.
@param s Original input string with an extra space at the end
@param ans Output string
@param n Characters left to process
@return Output string
-}
calc :: [Char] -> [Char] -> Int -> [Char]
calc s ans n
  | n == 1 = ans -- Base case.
  | fst == 'A' && snd /= 'A' || fst /= 'A' && snd == 'A' = calc (tail s) (fst : ans) (n-1) -- Recursive case.
  | otherwise = calc (tail s) (' ' : fst : ans) (n-1) -- Recursive case.
  where fst = s !! 0
        snd = s !! 1

main :: IO ()
main = getLine >>= \s -> putStrLn $ reverse $ calc (s ++ " ") "" (length s + 1)
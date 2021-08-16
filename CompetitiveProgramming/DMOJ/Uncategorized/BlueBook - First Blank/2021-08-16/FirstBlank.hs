{-
--------------------------------------------------------------------------------
---------------------------- BlueBook - First Blank ----------------------------
Find the position of the first occurance of a space. Output 0 if there are no spaces in a line.

Sample Input
2
 2
22

Sample Input Explanation
Line 1: n, number of strings.
Line 2 to n+1: strings to find the position of the first space.

Sample Output
1
0

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
For languages whose built index function returns -1, one can directly output the returned value + 1.
Extra processing required for languages that do not always return integers, e.g., Haskell.
Alternatively, use a for loop through the strings.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find the first position of a space.
@author Vincent Zhang
@since 16 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Data.List ( elemIndex )

{-
Solves the problem.
@return interact
-}
main :: IO ()
main = interact $ unlines . map (show . index) . tail . lines
  where index s = calc $ elemIndex ' ' s
          where calc Nothing = 0
                calc (Just s) = s+1
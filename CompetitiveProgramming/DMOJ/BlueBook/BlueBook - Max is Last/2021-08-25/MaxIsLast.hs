{-
--------------------------------------------------------------------------------
---------------------------- BlueBook - Max is Last ----------------------------
Given a list of numbers, print the max value last.

Sample Input
4
3
2.7
5.12
-0.63

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: list of numbers.

Sample Output
3.00
2.70
-0.63
5.12

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find max, print the rest without max, print max.
E.g., by creating new list without max, iterating through list and not printing max.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Prints a list with the maxiumum value last.
@author Vincent Zhang
@since 25 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Text.Printf ( printf )

{-
Solves the problem.
@return IO
-}
main :: IO ()
main = do
  a <- map (read :: String -> Double) . tail . lines <$> getContents
  let max = maximum a
  let b = [x | x <- a, x /= max]
  mapM_ (printf "%.2f\n") b
  printf "%.2f\n" max
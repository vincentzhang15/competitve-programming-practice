{-
----------------------------------------------------------------------
---------------------------- List Minimum ----------------------------
Given a list of numbers, remove the minimum from the list until the list is empty.

Sample Input
3
5
8
2

Sample Output
2
5
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Problem description is the definition of selection sort in ascending order.
Therefore, it sufices to sort with built-in function if avaiable.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Outputs a list of numbers in ascending order.
@author Vincent Zhang
@since 28 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Data.List

{-
Solves the problem.
@return IO
-}
main :: IO ()
main = getContents >>= \xs -> mapM_ print . sort . map (read :: String -> Int) . tail . lines $ xs
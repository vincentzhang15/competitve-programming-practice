{-
--------------------------------------------------------------------------------------
---------------------------- BlueBook - Column of Numbers ----------------------------
Prints a string of digits in reverse order, column-wise.

Sample Input
3467

Sample Output
7
6
4
3

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Reverse print.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Reverses a list of digits.
@author Vincent Zhang
@since 25 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Data.List ( intersperse )

{-
Solves the problem.
@return IO
-}
main :: IO ()
main = getLine >>= \s -> mapM_ putStrLn . words . intersperse ' ' . reverse $ s
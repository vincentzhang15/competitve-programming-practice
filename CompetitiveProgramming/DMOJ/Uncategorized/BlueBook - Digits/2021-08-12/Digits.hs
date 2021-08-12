{-
---------------------------------------------------------------------------
---------------------------- BlueBook - Digits ----------------------------
Find number of digits of each number. Negative sign is not a digit.

Sample Input
4
123
1
-12
0

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: numbers.

Sample Output
3
1
2
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find absolute value of every number then its string length.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the number of digits in a list of numbers.
@author Vincent Zhang
@since 12 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

-- Alternative one-liner.
-- main = getContents >>= \a -> mapM_ (print . length . show . abs . (read::String->Int)) $ tail $ words a
{-
Solves the problem.
@return print
-}
main :: IO ()
main = do
    a <- getContents
    let b = tail $ words a
    let c = map (read::String->Int) b
    let d = map abs c
    let e = map show d
    let f = map length e
    mapM_ print f
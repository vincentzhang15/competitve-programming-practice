{-
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
@context Self-Learning Haskell
-}

module Main(main) where

{-
Solves the problem.
@return IO
-}
main :: IO ()
main = getContents >>= \s -> (mapM_ (calc . (read :: String -> Int)) . tail . lines) s
    where calc x
            | x >= 80 && x <= 100 = putStrLn "A"
            | x >= 70 && x <= 79 = putStrLn "B"
            | x >= 60 && x <= 69 = putStrLn "C"
            | x >= 50 && x <= 59 = putStrLn "D"
            | x >= 0 && x <= 49 = putStrLn "F"
            | otherwise = putStrLn "X"
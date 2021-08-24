{-
---------------------------------------------------------------------------------
---------------------------- BlueBook - Times Tables ----------------------------
Create a times table for "n" from 1 to n.

Sample Input
5

Sample Output
5 X 1 = 5
5 X 2 = 10
5 X 3 = 15
5 X 4 = 20
5 X 5 = 25

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop from 1 to n and multiply.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Creates a column in a times table.
@author Vincent Zhang
@since 24 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Solve the problem.
@param x Value for "n"
@param a List of values from 1 to "n"
@return IO
-}
calc :: Int -> Int -> IO ()
calc x a = do
  putStrLn $ show x <> " X " <> show a <> " = " <> show (x * a)

{-
Control IO and program flow.
@return IO
-}
main :: IO ()
main = do
  n <- (read :: String -> Int) <$> getLine
  mapM_ (calc n) [1..n]
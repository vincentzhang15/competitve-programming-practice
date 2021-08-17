{-
-----------------------------------------------------------------------------------
---------------------------- BlueBook - Exact Divisors ----------------------------
Print all exact divisors of a number in any order. Includes 1 and N.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check every number from 1 to N. O(N) with loop.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find all exact divisors of a number.
@author Vincent Zhang
@since 17 August 2021
@context Self-Learning Haskell
-}

{-
Solves the problem.
@return IO
-}
main :: IO ()
main = do
  n <- (read :: String -> Int) <$> getLine
  mapM_ print [x | x <- [1..n], mod n x == 0]
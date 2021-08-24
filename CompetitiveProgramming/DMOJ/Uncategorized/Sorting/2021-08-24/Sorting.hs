{-
-----------------------------------------------------------------
---------------------------- Sorting ----------------------------
Sort a list <=100 of integers <= 32000 in ascending order.

Sample Input
4
4
3
2
1

Sample Output
1
2
3
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built in sorting method.
Or write own sorting method.
O(N^2) selection sort will work.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Sorts a list of integers.
@author Vincent Zhang
@since 24 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Data.List ( sort )

{-
Solves the problem.
@return print
-}
main :: IO ()
main = do
  a <- getContents
  let b = tail . lines $ a
  let c = map (read :: String -> Int) b
  let d = sort c
  mapM_ print d
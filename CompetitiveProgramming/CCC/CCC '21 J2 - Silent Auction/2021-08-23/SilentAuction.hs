{-
-------------------------------------------------------------------------------------
---------------------------- CCC '21 J2 - Silent Auction ----------------------------
Find the name of the first bidder with the highest price.

Sample Input 1
3
Ahmed
300
Suzanne
500
Ivona
450

Sample Output 1
Suzanne

Sample Input 2
2
Ijeoma
20
Goor
20

Sample Output 2
Ijeoma

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find the max price.
Find the first name with the max price.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the first highest bidder.
@author Vincent Zhang
@since 23 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Data.List ( elemIndex, partition )
import Data.Maybe ( fromMaybe )

{-
Solves the problem.
@return putStrLn
-}
main :: IO ()
main = do
  a <- tail . lines <$> getContents
  let (b, c) = Data.List.partition (even . fst) (zip [0 .. ] a)
  let (_, d) = unzip b
  let (_, e) = unzip c
  let values = map (read :: String -> Int) e
  let names = d
  let maxValue = maximum values
  let idx = fromMaybe (-1) $ elemIndex maxValue values
  putStrLn $ names !! idx
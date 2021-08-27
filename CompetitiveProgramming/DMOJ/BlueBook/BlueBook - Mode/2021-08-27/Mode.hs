{-
-------------------------------------------------------------------------
---------------------------- BlueBook - Mode ----------------------------
Find mode of a set of positive non-zero integers <= 100.

Sample Input
2
3
4
4
-1

Sample Output
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find max frequency, then sort all modes with the frequency.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the mode of a dataset.
@author Vincent Zhang
@since 27 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Data.List ( maximumBy, group, sort )
import Data.Ord ( comparing )

{-
Solves the problem.
@return IO
-}
main :: IO ()
main = do
    a <- map (\x -> (length x, head x)) . group . sort . init . lines <$> getContents
    let m = maximumBy (comparing fst) a
    let b = sort [ (read :: String -> Int) (snd x) | x <- a, fst x == fst m]
    mapM_ print b

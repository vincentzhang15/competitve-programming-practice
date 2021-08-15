{-
------------------------------------------------------------------------------------------
---------------------------- CCC '21 J3 - Secret Instructions ----------------------------
Determine the direction of travel and number of steps given 5-digit numbers, e.g., 12345.

First two digits represent direction of turn.
    Sum odd: left
    Sum even: right
    Sum zero: previous direction
Last three digits is number of steps.
"99999": end program.

Sample Input
57234
00907
34100
99999

Sample Output
right 234
right 907
left 100

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Take input as string and extract first two digits.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to determine directions.
@author Vincent Zhang
@since 15 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Control.Monad ( foldM_ )
import Data.Char ( digitToInt )
import Data.Functor ( ($>) )

{-
Solves the problem.
@return Output
-}
main :: IO ()
main = calc . init . lines =<< getContents
  where
    calc = foldM_ find ""
      where
        find p (a:b:s)
          | sum == 0 = putStrLn(p <> " " <> s) $> p
          | odd sum  = putStrLn("left " <> s)  $> "left"
          | even sum = putStrLn("right " <> s) $> "right"
          where
            sum = digitToInt a + digitToInt b

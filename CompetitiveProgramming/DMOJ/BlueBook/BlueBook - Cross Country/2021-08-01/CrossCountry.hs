{-
--------------------------------------------------------------------------
---------------------------- HASKELL CONCEPTS ----------------------------
1. Lookup Returns a "maybe" value so output will have "Just [...]".
    https://stackoverflow.com/questions/18864080/haskell-use-maybe-but-print-an-actual-number-rather-than-just
    Add maybe to process item not found case.
    maybe (putStrLn "invalid code") putStrLn $ Map.lookup s d

----------------------------------------------------------------------------------
---------------------------- BlueBook - Cross Country ----------------------------
Given a two digit code, output one of the following corresponding results.
If a code does not exist output "invalid code".

Code 	Output
MG 	    midget girls
MB 	    midget boys
JG 	    junior girls
JB 	    junior boys
SG 	    senior girls
SB 	    senior boys

Sample Input
JG

Sample Output
junior girls

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Store codes in a map or check cases with if-else.

-------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ---------------------------
Program to output the matching result of a code if it exists.
@author Vincent Zhang
@since 01 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Data.Map (Map)
import qualified Data.Map as Map

main :: IO ()
main = do
  s <- getLine
  let d = Map.fromList [
                         ("MG", "midget girls"),
                         ("MB", "midget boys"),
                         ("JG", "junior girls"),
                         ("JB", "junior boys"),
                         ("SG", "senior girls"),
                         ("SB", "senior boys")
                       ]
  maybe (putStrLn "invalid code") putStrLn $ Map.lookup s d
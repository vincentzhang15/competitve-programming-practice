{-
-------------------------------------------------------------------------------
---------------------------- BlueBook - Lower Case ----------------------------
Convert given strings to lowercase.

Sample Input
2
abCDefg
WEEEIPWNNOOBS~~?~?~??@#!#$%?$^?$%*

Sample Output
abcdefg
weeeipwnnoobs~~?~?~??@#~#$%?$^?$%*

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built-in lower case functions or loop through characters and check if uppercase.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to convert strings to lowercase.
@author Vincent Zhang
@since 19 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Data.Char ( toLower )

{-
Solves the problem.
@return putStrLn
-}
main :: IO ()
main = getContents >>= \x -> mapM_ (putStrLn . map toLower) . tail . lines $ x
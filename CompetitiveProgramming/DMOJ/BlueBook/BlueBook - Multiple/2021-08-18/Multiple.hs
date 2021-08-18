{-
-----------------------------------------------------------------------------
---------------------------- BlueBook - Multiple ----------------------------
Given two positive integers, "a", "b", determine if "a" is a mulitple of "b".
Output "yes" or "no".

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
if a % b == 0
    "yes"
else
    "no"

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to check if "a" is a mulitple of "b".
@author Vincent Zhang
@since 18 August 2021
@context Self-Learning Haskell
-}

main = (read::String->Int) <$> getLine >>= \a -> (read::String->Int) <$> getLine >>= \b -> putStrLn $ if mod a b == 0 then "yes" else "no"
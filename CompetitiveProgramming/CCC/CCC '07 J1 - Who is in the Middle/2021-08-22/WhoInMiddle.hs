{-
--------------------------------------------------------------------------------------------
---------------------------- CCC '07 J1 - Who is in the Middle? ----------------------------
Find the middle number of three numbers.

Sample Input
10
5
8

Sample Output
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
One way is to sort the list and output list[1].
Another way is to subtract max and min from the trio sum.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the middle number in three numbers.
@author Vincent Zhang
@since 22 August 2021
@context Self-Learning Haskell
-}

main = (read::String -> Int) <$> getLine >>= \a -> (read::String -> Int) <$> getLine >>= \b -> (read::String -> Int) <$> getLine >>= \c -> print $ a+b+c-(min a (min b c))-(max a (max b c))
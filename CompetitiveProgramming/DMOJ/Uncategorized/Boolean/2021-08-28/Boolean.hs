{-
-----------------------------------------------------------------
---------------------------- Boolean ----------------------------
Evaluate a boolean expression.

Sample Input 1
not not True

Sample Output 1
True

Sample Input 2
not not not False

Sample Output 2
True

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Count the number of "not". Even number will cancel out. Only need to apply one negation if odd.
Another way is to XOR while taking input, and compare initial assumed value with final True/False.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Evaluates a boolean expression.
@author Vincent Zhang
@since 28 August 2021
@context Self-Learning Haskell
-}

import Data.List ( group )

{-
Perform the evaluation of expressions with more than 1 "not".
@param a List containing "not" grouped together and final True/False
@return IO
-}
calc :: [[String]] -> IO ()
calc a = do
    let isEven = even . length . head $ a
    if isEven then
        putStrLn . head . last $ a
    else
        if (head . last) a == "False" then
            putStrLn "True"
        else
            putStrLn "False"

{-
Control IO
@return IO
-}
main :: IO ()
main = do
    a <- group . words <$> getContents
    if null a then
        putStr ""
    else if length a == 1 then
        putStrLn . head . head $ a
    else
        calc a

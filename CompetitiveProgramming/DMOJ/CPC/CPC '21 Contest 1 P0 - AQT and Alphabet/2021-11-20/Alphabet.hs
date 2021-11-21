module Main(main) where

import Data.List

main :: IO ()
main = do
    s <- getLine
    putStrLn [ head $ ['a'..'f'] \\ s ]
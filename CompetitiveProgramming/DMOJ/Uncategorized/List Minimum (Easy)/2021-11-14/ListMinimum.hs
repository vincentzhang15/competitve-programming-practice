module Main(main) where

main :: IO ()
main = do
    n <- readLn :: IO Int
    putStr . unwords . map show $ [1..n]
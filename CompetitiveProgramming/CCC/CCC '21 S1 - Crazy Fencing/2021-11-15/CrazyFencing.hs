module Main(main) where

main :: IO ()
main = do
    n <- readLn :: IO Int
    b <- map read . words <$> getLine :: IO [Int]
    h <- map read . words <$> getLine :: IO [Int]
    print $ fromIntegral ( sum (zipWith (*) h (zipWith (+) (init b) (tail b)) ) ) / 2

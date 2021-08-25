module Main(main) where

main :: IO ()
main = do
  a <- last . map (read :: String -> Integer) . words <$> getLine
  b <- sum . map (product . map (read :: String -> Integer) . words) . lines <$> getContents
  print $ mod b a
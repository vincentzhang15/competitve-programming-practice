<?php

$n = (int)fgets(STDIN);
$b = explode(' ', fgets(STDIN));
$h = explode(' ', fgets(STDIN));

$ans = 0;
for($i = 0; $i < $n; $i++)
{
    $ans += ($b[$i] + $b[$i + 1]) * $h[$i];
}
echo $ans / 2;

# echo $n . "\n";
# print_r($b);
# print_r($h);

?>

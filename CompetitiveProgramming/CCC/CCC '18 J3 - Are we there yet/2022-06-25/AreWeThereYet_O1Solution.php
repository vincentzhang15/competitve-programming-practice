<?php
/*
CCC '18 J3 - Are we there yet?

O(1) solution by simplying adding.

@author Vincent Zhang
@since 25 June 2022
@context Self-Learning PHP
*/

function main()
{
    $n = 2;
    [$a, $b, $c, $d] = array_map('intval', explode(' ', fgets(STDIN))); // Symmetric array destructuring; https://stackoverflow.com/questions/10029699/explode-string-into-variables
    
    echo "0 ", $a, " ", $a+$b, " ", $a+$b+$c, " ", $a+$b+$c+$d , " \n";
    echo $a, " 0 ", $b, " ", $b+$c, " ", $b+$c+$d, " \n";
    echo $a+$b, " ", $b, " 0 ", $c, " ", $c+$d, " \n";
    echo $a+$b+$c, " ", $b+$c, " ", $c, " 0 ", $d, " \n";
    echo $a+$b+$c+$d, " ", $b+$c+$d, " ", $c+$d, " ", $d, " 0 \n";
}

main()

?>
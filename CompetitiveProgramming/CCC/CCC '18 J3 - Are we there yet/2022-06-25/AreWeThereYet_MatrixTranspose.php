<?php
/*
CCC '18 J3 - Are we there yet?

Notice that the result is a 5x5 symmetric matrix with 0 main diagonal.
Find prefix sum and add the symmetric position. Or take the transpose, then sum.

@author Vincent Zhang
@since 25 June 2022
@context Self-Learning PHP
*/

function main()
{
    $data = array_map('intval', explode(' ', fgets(STDIN)));
    $E = count($data);
    $mat = array_fill(0, $E+1, array_fill(0, $E+1, 0)); // index, count, value
    
    # Find prefix sum.
    for($i=0; $i<$E+1; $i++)
        for($j=$i+1; $j<$E+1; $j++)
            $mat[$i][$j] = $data[$j-1] + $mat[$i][$j-1];
        
    # Add symmetric position.
    for($i=0; $i<$E+1; $i++)
        for($j=0; $j<$i; $j++)
            $mat[$i][$j] = $mat[$j][$i];
    
    # Output result.
    foreach($mat as $row)
    {
        foreach($row as $col)
            echo $col, ' ';
        echo "\n";
    }
}

main()
?>
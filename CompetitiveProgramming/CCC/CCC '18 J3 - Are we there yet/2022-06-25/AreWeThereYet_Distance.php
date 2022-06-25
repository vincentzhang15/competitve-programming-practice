<?php
/*
CCC '18 J3 - Are we there yet?

Take inspiration from probability. P(X>=3)=1-P(P<3). Here, 3 represents index in prefix sum array and 1 represents value at last index of prefix sum array.
So distance from index 3 to end is simply value at end index - value at index 3.

@author Vincent Zhang
@since 25 June 2022
@context Self-Learning PHP
*/

function main()
{
    $data = array_map('intval', explode(' ', fgets(STDIN)));
    for($i=1; $i<count($data); $i++)
        $data[$i] += $data[$i-1];
    array_splice($data, 0, 0, 0); // arr, offset, len, replacement; i.e., replace nothing at the beginning of array with 0, which adds 0 to beginning.

    for($i=0; $i<5; $i++)
    {
        for($j=0; $j<5; $j++)
            echo abs($data[$j]-$data[$i]), " ";
        echo "\n";
    }
}

main()

?>
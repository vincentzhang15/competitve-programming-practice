<?php
/*
CCC '18 J3 - Are we there yet?

Solution Logic:
 v
  3 10 12 5
   v
  3 10 12 5
  ...
           v
  3 10 12 5

  Insert pivot between each pair of numbers and compute prefix sum in either directions.

@author Vincent Zhang
@since 25 June 2022
@context Self-Learning PHP
*/

function main()
{
    $data = array_map('intval', explode(' ', fgets(STDIN)));
    $E = count($data);

    for($k=0; $k<$E+0.5; $k++) {
        $i = $k-0.5;
        $idx_fwd = ceil($i)+1;
        $idx_rev = floor($i);

        $out = array_merge(array_slice($data, 0, $idx_rev+1), array(0), array_slice($data, $idx_fwd-1));
        for($j=$idx_fwd; $j<$E+1; $j++)
            $out[$j] += $j-1>=0 ? $out[$j-1] : 0;
        for($j=$idx_rev; $j>=0; $j--)
            $out[$j] += $j+1<$E ? $out[$j+1] : 0;
        
        foreach($out as $o)
            echo $o, " ";
        echo "\n";
    }
}

main()
?>
<?php
$n = (int)readline();

$data = [];
for($i=0; $i<$n; $i++)
{
    $x = readline();
    $data[] = $x;
}
sort($data);

foreach($data as $val)
{
    echo $val, "\n";
}
?>
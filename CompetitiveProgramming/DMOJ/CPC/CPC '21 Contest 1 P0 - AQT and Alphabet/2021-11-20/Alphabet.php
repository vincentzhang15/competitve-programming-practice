<?php

$s = fgets(STDIN);

foreach(range('a', 'f') as $v)
{
    if(strpos($s, $v) === false)
    {
        echo $v . "\xA";
        break;
    }
}

?>
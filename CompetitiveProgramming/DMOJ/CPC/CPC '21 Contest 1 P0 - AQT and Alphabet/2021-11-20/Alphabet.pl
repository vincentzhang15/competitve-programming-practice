#!usr/bin/perl -l
use warnings;
use strict;

my $s = <STDIN>;

for my $a ('a' ..'f')
{
    if(index($s, $a) == -1)
    {
        print $a;
        last;
    }
}

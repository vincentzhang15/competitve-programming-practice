#!usr/bin/perl
use warnings;
use strict;

my $n = <STDIN>;
my @b = split(' ', <STDIN>);
my @h = split(' ', <STDIN>);

my $ans = 0;
for my $i (0 .. $n-1)
{
    $ans += ($b[$i] + $b[$i+1]) * $h[$i];
}

print $ans / 2;
#!usr/bin/perl
use warnings;
use strict;

my $n = <STDIN>;
my @a = (1..$n);
foreach(@a)
{
    print("$_ ");
}

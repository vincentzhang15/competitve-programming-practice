"""
NEWLY LEARNT TECHNIQUES SUMMARY

1. LIST COMPREHENSION: POPULATE LIST WITH AN INTEGRATED FOR LOOP
adjs = [input() for i in range(nAdjs)]
"""

"""
PROBLEM DESCRIPTION

CCC '04 J3 - Smile with Similes
A program that prints all possible similes based on inputed adjectives and nouns.

Sample input:
3
2
Easy
Smart
Soft
pie
rock

Sample Output:
Easy as pie
Easy as rock
Smart as pie
Smart as rock
Soft as pie
Soft as rock

@author Vincent Zhang
@since 28 June 2021
@context Learning Python 3
"""

# Input: number of adjs and nouns.
nAdjs = int(input())
nNouns = int(input())

# Store adjectives and nouns from input with list comprehension.
adjs = [input() for i in range(nAdjs)]
nouns = [input() for i in range(nNouns)]

# Output results.
for adj in adjs:
	for noun in nouns:
		print(adj, "as", noun)

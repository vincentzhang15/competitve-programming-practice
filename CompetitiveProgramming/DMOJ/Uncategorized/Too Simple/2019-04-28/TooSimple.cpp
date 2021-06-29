#include <iostream>
using namespace std;

int main()
{
	char data [] = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
	for(char c : data)
		printf("%c", c);
	//printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33);
	
	return 0;
}
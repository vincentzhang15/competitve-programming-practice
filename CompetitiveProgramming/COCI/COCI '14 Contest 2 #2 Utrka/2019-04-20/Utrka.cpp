#include <iostream>
#include <cstring>
using namespace std;

int main()
{
	char s [21];
	int data [26][20];
	memset(data, 0, sizeof data);
	int n;
	scanf("%d", &n);
	
	for(int i = 0; i < n*2-1; i++)
	{
		scanf("%s", s);
		for(int j = 0; s[j] != '\0'; j++)
			data[s[j]-'a'][j]++;
	}
	
	for(int i = 0; i < 20; i++)
		for(int j = 0; j < 26; j++)
			if(data[j][i] % 2 != 0)
				printf("%c", j+'a');
	printf("\n");
	
	return 0;
}
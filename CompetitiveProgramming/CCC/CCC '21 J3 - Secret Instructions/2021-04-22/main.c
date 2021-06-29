#include <stdio.h>
#include <string.h>

int main()
{
	int dir = 0; // 0 left, 1 right
	while(1)
	{
		char s[6];
		scanf("%s", s);
		
		if(!strcmp(s, "99999"))
		{
			return 0;
		}
		
		
		int sum = (int)(s[0]-'0') + (int)(s[1]-'0');
		if(sum == 0)
		{
			if(dir == 0)
				printf("left ");
			else
				printf("right ");
		}
		else if(sum % 2 == 0)
		{
			dir = 1;
			printf("right ");
		}
		else
		{
			dir = 0;
			printf("left ");
		}
		char out[4];
		strncpy(out, s+2, 3);
		out[3] = '\0';
		printf("%s\n", out);
	}
	return 0;
}
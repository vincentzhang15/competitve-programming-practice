#include <stdio.h>
#include <string.h>

char s[6];

int main(int argc, char **argv)
{
    scanf("%s", s);

    for(int i=97; i<97+6; i++)
    {
        char c = (char)i;
        char *pos = strchr(s, c);

        if(pos == NULL)
        {
            printf("%c\n", c);
            break;
        }
    }

    return 0;
}
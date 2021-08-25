#include <stdio.h>
#include <ctype.h> // tolower()
#include <string.h>

char line1[28], line2[8];

int main(int argc, char **argv)
{
    scanf(" %[^\n]s", line1);
    
    char *t = strchr(line1, '.');
    int idx = t ? t - line1 : -1;

    if(idx == -1)
    {
        scanf(" %[^\n]s", line2);
        printf("\"%s\" - ", line1);
        for(int i=0; line2[i] != '\0'; i++)
        {
            printf("%c", tolower(line2[i]));
        }
    }
    else
    {
        printf("\"");
        for(int i=0; i<idx; i++)
        {
            printf("%c", line1[i]);
        }
        printf("\" - ");
        for(int i=idx+1; line1[i] != '\0'; i++)
        {
            printf("%c", tolower(line1[i]));
        }
    }

    return 0;
}
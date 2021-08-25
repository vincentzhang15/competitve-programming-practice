#include <stdio.h>

char line[103];
int alpha[26];

int main(int argc, char **argv)
{
    scanf("%s", line);

    for(int i=0; i <26; i++)
    {
        char c = (char)(i+97);
        int count = 0;
        for(int j=0; line[j] != '\0'; j++)
        {
            if(line[j] == c)
                count++;
        }
        alpha[i] = count;
    }

    int sum = 0;
    int max1 = -1;
    int count = 0;
    int items = 0;
    for(int i =0; i<26; i++)
    {
        if(alpha[i] != 0)
        {
            items ++;
        }

        sum += alpha[i];
        if(alpha[i] > max1)
        {
            max1 = alpha[i];
            count = 1;
        }
        else if(alpha[i] == max1)
        {
            count++;
        }
    }

    int max2 = 0;
    if(count == 1)
    {
        for(int i=0; i<26; i++)
        {
            if(alpha[i] > max2 && alpha[i] != max1)
            {
                max2 = alpha[i];
            }
        }
    }

    if(items <=2)
        printf("0\n");
    else
    {
        if(count == 1)
        {
            printf("%d\n", sum-max1-max2);
        }
        else
        {
            printf("%d\n", sum-max1-max1);
        }
    }

    return 0;
}
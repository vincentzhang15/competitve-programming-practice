#include <stdio.h>

int n;

int main(int argc, char **argv)
{
    scanf("%d", &n);
    for(int i=1; i<=n; i++)
    {
        printf("%d ", i);
    }

    return 0;
}
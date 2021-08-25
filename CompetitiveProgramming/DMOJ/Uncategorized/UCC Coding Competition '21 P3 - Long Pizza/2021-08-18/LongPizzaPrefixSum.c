#include <stdio.h>

int n, x, y, r, a, b;
long s;
int data[10000003];

int main(int argc, char **argv)
{
    scanf("%d %d %d %d", &n, &x, &y, &r);
    for(int i=0; i<r; i++)
    {
        scanf("%d %d", &a, &b);
        data[a] += 1;
        data[b+1] -= 1;
    }
    for(int i=2; i<=n; i++)
    {
        data[i] += data[i-1];
    }
    for(int i=x; i<=y; i++)
    {
        s += data[i];
    }
    printf("%ld\n", s);

    return 0;
}
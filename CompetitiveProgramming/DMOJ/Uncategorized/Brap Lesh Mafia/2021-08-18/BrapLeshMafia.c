#include <stdio.h>

long long n, m, a, b, s=0;

int main(int argc, char *argv[])
{
    scanf("%lld %lld", &n, &m);

    for(int i=0; i<n; i++)
    {
        scanf("%lld %lld", &a, &b);
        s = (s + a * b) % m;
    }
    printf("%lld", s);

    return 0;
}
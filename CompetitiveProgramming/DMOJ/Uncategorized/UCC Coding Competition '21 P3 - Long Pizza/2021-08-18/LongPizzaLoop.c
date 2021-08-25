#include <stdio.h>

#define max(a, b) ({ __typeof__ (a) _a = (a); __typeof__ (b) _b = (b); _a > _b ? _a : _b; })
#define min(a, b) ({ __typeof__ (a) _a = (a); __typeof__ (b) _b = (b); _a < _b ? _a : _b; })

int n, x, y, r, a, b;
long s;

int main(int argc, char *argv[])
{
    scanf("%d %d %d %d", &n, &x, &y, &r);

    for(int i=0; i<r; i++)
    {
        scanf("%d %d", &a, &b);
        int lo = max(a, x);
        int hi = min(b, y);
        int v = hi - lo + 1;
        if(v > 0)
            s += v;
    }
    printf("%ld\n", s);

    return 0;
}
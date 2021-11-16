#include <stdio.h>

int n, b[10003], h[10003];

int main(int argc, char **argv)
{
    scanf("%d", &n);
    for(int i=0; i<=n; i++)
    {
        scanf("%d", &b[i]);   
    }
    for(int i=0; i<n; i++)
    {
        scanf("%d", &h[i]);
    }

    int ans = 0;
    for(int i=0; i<n; i++)
    {
        ans += (b[i] + b[i+1]) * h[i];
    }

    printf("%.1f", ans/2.0);
    
    return 0;
}
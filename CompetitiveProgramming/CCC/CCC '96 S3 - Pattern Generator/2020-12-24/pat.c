#include <stdio.h>

FILE * infp;
FILE * outfp;
int  t,      /* number of test cases  */
     n,      /* length of bit pattern */
     k,      /* number of ones in bit pattern */
     A[30]; /* array that stores bit pattern. A[0] is most significant bit */

void  printA(int i, int j)
/* See explanation for a specification of printA(i,j)  */
{
  int l;
  if (i==0 && j==0) {
    for ( l=0; l<n; l++ )  fprintf(outfp,"%d", A[l]); 
    fprintf(outfp, "\n");
  }
  else {
    if (j>0) { A[n-i]=1; printA(i-1,j-1); };
    if (i>j) { A[n-i]=0; printA(i-1,j); }
  }
}

main()
{
  infp = fopen( "pat.in", "r");
  outfp = fopen( "pat.out", "w");
  fscanf(infp, "%d", &t);
  while (t>0) {
    fscanf(infp, "%d %d",&n,&k); 
    fprintf(outfp,"The bit patterns are\n");
    printA(n,k); 
    t--; fprintf(outfp, "\n");
  }
}

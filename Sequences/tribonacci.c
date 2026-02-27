#include <stdio.h>

int find_nth(int n,int a,int b,int c)
{
    if(n==1) return a;
    if(n==2) return b;
    if(n==3) return c;

    return find_nth(n-1,b,c,a+b+c);
}

int main()
{
    int n=6;

    printf("Result = %d",find_nth(n,0,1,1));
}
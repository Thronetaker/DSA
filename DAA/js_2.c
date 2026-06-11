#include <stdio.h>
#include <conio.h>

int JS(int d[], int j[], int n ){
    int r ;
    d[0] = j[0] = 0;

    j[1] = 1;
    int k = 1 ;

    for(int i = 2; i <= n  ; i++){
        r = k ;

        while( d[j[r]] > d[i]  && d[j[r]] != r)   r = r-1;

        if( d[j[r]] <= d[i] && d[i] != i){

            for(int q = k ; q<= r+1 ; q--)    j[q+1] = j[q];   // heree decreaseeee

            j[r+1] = i;
            k = k+1;
        }
    }
    return k ;
}
int main(){

    return 0 ;
}
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

int x[20] ={0};

int place( int k , int i ){

    for( int j = 1 ; j<=k-1 ; j++){
        
        if( x[j] == i || abs( x[j] - i) == abs(j-k))   return 0;
    }

    return 1 ;
}


void NQueen(int k, int n ){

    for(int i = 1 ; i <=n ; i++){

        if( place( k,i)){

            x[k] = i;
            if( k== n )   {
                printf("Solution : - \n");
              for(int i = 1 ; i <= n ; i++){
               printf("%d ", x[i]);
              }

              printf("\n");
            }
            if(k<n)   NQueen(k+1, n);
        }
    }
}


int main(){
    int n;
    printf("enter numbof queens : ");
    scanf("%d", &n);
    NQueen(1,n);

}

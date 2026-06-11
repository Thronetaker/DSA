#include <stdio.h>
#include <stdbool.h>
#include <conio.h>


bool Place(int k , int  i, int x[]){
    
    for(int j = 1 ;j<= k-1 ; j++){    // j, k =  row      i = col
        if( x[j] == i   ||  ( abs( x[j] = i) == abs( j == k)) ){
            return false ;
        }
    }

    return true ;
}


void nqueen(int k , int n ,int x[]){

   for(int i = 1 ;i <= n ; i++){
     if( Place(k , i ,x)){
        x[k] = i ;   // k = row   i = col 

        if( k == n ){
            printf("Solution : ");
            for(int row = 1 ; row<= n ; row++){
                printf("%d ", x[row]);
            }
        }else{
            nqueen(k+1, i, n,x);
        }
    }
   }
}


int main(){
    int x[15],n;

    printf("enter size : ");
    scanf("%d",&n);

    for(int i = 0 ; i <= n ; i++){
        x[i] = 0;
    }

    nqueen(1,n , x );
    return 0 ;
}
#include <stdio.h>
#include <conio.h>

void nextValue(int k , int n , int x[20], int G[20][20], int m){
    int j ;
    do{
        x[k] = ( x[k] + 1) % (m+1);

        if( x[k] == 0) return ;

        for( j = 1 ; j <= n ; j++){
            if( G[k][j] != 0  && x[k] == x[j]) break;
        }

        if(j == n+1 ) return ;


    }while(1);

    
}

void mColor(int k , int n , int x[20], int G[20][20], int m ){
    
    do{
        nextValue(k, n , x, G, m);

        if( k == n){
            for(int i = 1 ; i <= n ; i++)  {
                printf("%d ", x[i]);
            }
        }else{
            mColor(k+1,n , x,G,m);
        }

    }while(1);
}

int main(){
    int n , m , G[20][20], x[15];

    //n = vertices
    printf("Enter numbers of vertices  : ");
    scanf("%d", &n);

    //m = color
    printf("Enter numbers of colors : ");
    scanf("%d", &m);

    for(int i = 0 ; i <= n ; i++){
        x[i] = 0;
    }

    adjMatrix(G,n);

    mColor(1,n,x,G,m);

    return 0 ;
}
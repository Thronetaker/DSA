#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

void adjMatrix(int G[20][20], int n , int m){
    int  x,y;

    for(int i = 0 ;i<=n;i++){
        for(int j =0;j<=n ;j++){
            G[i][j] = 0;
        }
    }
   
    printf("enter edges : ");
    for(int i = 1 ;i<= m ;i++){
        scanf("%d %d", &x, &y);
        G[x][y] = 1 ;
        G[y][x]=1;
    }
}

void nextValue(int G[20][20], int n , int x[], int k){
    int j ;
    do{
        x[k] = ( x[k] + 1 )% (n+1);
    if(x[k] == 0 ) return ;

    if( G[x[k-1]][x[k]] != 0){
        for(j = 1; j <= k-1 ;j++)   {
            if( x[j] == x[k]) break ;
        }

        if( j == k ){
            if( (k<n) || ( k==n && G[x[n]][x[1]] != 0 ))  return;
        }
    }
    }while(1);
}


void hamiltonian(int G[20][20], int n , int x[], int k ){
    do{
        nextValue(G,n,x,k);
    if(x[k] == 0) return ;

    if(k == n){
        printf(" First Solution : ");
        for(int i = 1 ; i<= n ; i++){
            printf("%d ", x[i]);
        }
        printf("\n");
    }else{
        hamiltonian(G,n,x,k+1);
    }

    }while(1);

}

int main(){
    int G[20][20], n, m,x[10];
    //n = vertices     m= edges

    printf("%Enter no of vertices in graph : ");
    scanf("%d",&n);
     printf("%Enter no of edges in graph : ");
    scanf("%d",&m);

    for(int i = 1 ; i <= n ; i++){
        x[i] = 0;
    }

    adjMatrix(G, n,m );
    x[1] = 1 ; //dont forget it 
    hamiltonian(G, n, x,2);
    

    return 0 ;
    
}
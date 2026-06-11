#include <stdio.h>
#include <conio.h>
int x[10] = {0};
int g[10][10];  
int m ,n;
void display(int n );

void NextValue(int k  ){
    while(1){int j ;
    x[k ]= (x[k]+1 ) % (m+1);

    if( x[k] == 0) return ;

    for (j = 1 ; j<=n ; j++)
              if( g[j][k] !=0    &&  x[j] == x[k]) break;

    if( j == n+1) return ;}
    
}

void mcolor(int k, int n  ){
    do{
        NextValue(k);
        if(x[k] == 0) return ;
        if( k == n ){
            for(int i = 1 ;i<= k ; i++){
                printf("%d ", x[i]);
            }
            printf("\n");
        }

        else{
            mcolor(k+1,n);
        }

    }while(1);
}

void adjMatrix(){
    int   edges, u,v;
    printf("Enter numbers of colors :  ");
    scanf("%d", &m);
    printf("Enter numbers of edges  AND vertices: ");
    scanf("%d%d", &edges, &n);

    for(int i =1 ; i<= n ; i++){
        for(int j =1 ; j<= n ; j++){
            g[i][j] = 0;
        }
    }

    for(int i = 1 ; i <= edges ;i++){
        printf( "Enter %d edge's vertex u and v : ", i);
        scanf("%d%d",&u,&v);
        g[u][v] = 1;
        g[v][u] = 1;
    }

    display(n);
}

void display(int n ){
    for(int i =1 ; i<= n ; i++){
        for(int j =1 ; j<= n ; j++){
            printf("%d ", g[i][j]);
        }
        printf("\n");
    }

}
int main(){
    adjMatrix();
    mcolor(1,n );

    return 0 ;
}
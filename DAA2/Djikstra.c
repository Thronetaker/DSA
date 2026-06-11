#include <stdio.h>
int g[20][20];


void adj(){
    int u ,n, v,edges;
    printf("enter no. of vertices an d edges : ");
    scanf("%d%d", &n,&edges);

    for(int i = 1 ; i <= n ; i++){
        for(int j = 1 ; j<=n ; j++){
            g[i][j] = 999;
        }
    }

    for(int i = 1 ; i<= edges ;i++){
        printf(" enter edge %d ,(u,v)", i);
        scanf("%d%d",&u,&v);
        g[u][v] = 1;
    }
}

void djikstra(int v , int n ){
    int vis[15], dis[15], k;
    for(int i = 1 ; i<=n ; i++){
        vis[i] = 0;
        dis[i] = g[v][i];
    }

    vis[v] = 1 ; /// v marked visited 
    dis[v] = 0;


    for(int j = 2 ; j<=n ; j++){
        int min = 999;
        if( min>dis[j]){
            min = dis[j];
            k = j; ///store idx
        }
    }

    vis[k] = 1 ;
    for( int w = 1 ; w<=n ; w++){
        if( dis[w] > dis[k] + g[k][w])
            dis[w] = dis[k] + g[k][w];
    }

    //Shortest path from source to all vertices 
    for(int i = 1 ; i<=n ; i++){
        printf(" %d ", dis[i]);
    }
}


int main(){
    adj();


    return 0 ;
}
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

int q[20];
int qIdx = 1;

void add(int x){
     q[qIdx++] = x;
}

int  pop(){
    int y  = q[qIdx--];
    printf( " deleted %d", y);
    return y ;
}

void BFS(int g[][], int size, int v){

    visited[v] = 1;
    printf("%d ",v);
    add(v);
    while( qIdx!=0 ){
        int w = pop();

        for( int j = 1 ; j<=size ; j++){
            if( g[w][j] == 1  && visited[j]){
                //add to Queue
                add(j);
                visited[j] = 1;
                printf("%d ",j);
            }
              
        }
    }
}
void BFT(int g[][], int ver){

    for(int i =1 ; i<= ver ; i++){
        if( visited[i] != 0 ){
            BFS(g, i);
        }
    }

}




int main(){

    return 0 ;
}
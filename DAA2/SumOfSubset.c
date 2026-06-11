#include <stdio.h>
int w[] = {0,5,10,12,13,15,18};
int x[] = {0,0,0,0,0,0,0};

void SumOfSub(int k,int s , int r, int m ){

    x[k] = 1;
    if( s + w[k] == m ) {
        printf("Solution : \n");
        for(int i = 1 ; i<=6 ; i++){
            printf("%d ",x[i]);
        }
        printf("\n");
    }

    if( s + w[k] + w[k+1]<=m) SumOfSub(k+1, s+w[k], r - w[k], m);
    

    //right side of tree
    if( s+ r - w[k] >=m  && s+w[k+1] <=m){
        x[k] = 0;
        SumOfSub(k+1, s, r - w[k], m);
    }
}

int main(){
    SumOfSub(1,0, 73 ,30);

    return 0 ;
}
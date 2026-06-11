#include <stdio.h>

int p[] = {0,3,5,6,10};
int w[] = { 0,2,3,4,5};
int x[5] ={0,0,0,0,0};
int y[5] ={0,0,0,0,0};
int n = 4;
int m = 8;
int fp = 0 , fw = 0 ;

int Bound(int cp,int cw,int k){

    int b = cp ;int c = cw;

    for( int i =k  ;i<= n; i++ ){
        c =  c + w [i];

        if( c < m ) b = b+ p[i];
        else 
          return   b+ (1- (c-m) /w[i]) *p[i] ; 
    }

    return b ;
    

}

void Bknap(int cp,int cw,int k){

    if( cw + w[k] <= m){
        y[k] = 1 ;
        
        if( k<n) Bknap( cp+p[k], cw+w[k], k+1);

        if( (k==n)  && (cp + p[k] > fp)) {
            fp = cp + p[k];
            fw = cw + w[k];

            for( int i = 1 ; i<=k ; i++){
                x[i] = y[i];
            }
        }
    } 


    if( Bound( cp, cw, k) >= fp){

        y[k] = 0 ;
        if( k < n )  Bknap( cp,cw,k+1);

        if((k==n) && (cp > fp)  ){
            fp = cp ;
            fw = cw;

            for( int i =  1 ; i<=n ; i++){
                x[i] = y[i];
            }
        }
    }
}


void sort(int p[], int w[]){

    for( int i = 1 ;i<n;i++){
        int max = i;
        for(int j = i+1 ;j<=n; j++){
            float x = p[max]/w[max];
            float a = p[j]/w[j];
              if( x<a)   max = j;
        }

        if( max != i ){
            int temp = p[max];
             p[max] = p[i];
             p[i] = temp ;

             temp = w[max];
             w[max] = w[i];
             w[i] = temp ;
             
        }
    }
}

int main(){
    sort(p,w);
    Bknap(0,0,1);
    printf("Soltuion : - \n");

    for(int i = 1 ; i<= n ; i ++){
        printf(" %d", x[i]);
    }
    printf("\n");

    printf(" final profit and weight : %d   %d", fp, fw);
    

    return 0 ;
}
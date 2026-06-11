

// Online C compiler to run C program online
#include <stdio.h>

void js(int d[] , int j[], int n ){
    int k , i , r ;
    d[0] = 0;
    j[0] =0;
    
    j[1] = 1;
    k = 1;
    
    for(i = 2 ;i<= n ; i++){
        r = k ;
        if( d[j[r]] > d[i] && d[j[r]] !=r)   r = r-1;
        
        if( d[j[r]] <=  d[i] && d[i] > r){
            
            for(int q = k ; q>=(r+1) ; q--){
                j[q+1] = j[q];
            }
            
            j[r+1] = i ;
            k++;
        }
    }
}

int main() {
    

    return 0;
}
// Online C compiler to run C program online
#include <stdio.h>

void SumOfSubset(int s,int k , int r, int w[],int x[],int m,int n){
    
    x[k] = 1;  //curr ele included
    
    if(s + w[k] == m){
        printf(" Subset is :");
        for(int i = 1 ;i<=k ;i++){
            if( x[i]==1){
                printf("%d ",w[i]);
            }
        }
    }
    else if( k+1 <=n && s+w[k+1] <=m){
        SumOfSubset( s+w[k],k+1,r-w[k],w,x,m,n);
        
    }
    
    if( k+1 <= n ){
        if( (s+r -w[k] >=m) && (s+w[k]<=m)){
        x[k] = 0;
        SumOfSubset( s, k+1,r-w[k], w,x, m ,n);
        }
    }
}
int main() {
    int w[100], x[100],n,m,s,total_sum = 0;
    
    printf("Enter number of ele : ");
    scanf("%d",&n);
    
    for(int i = 1 ;i <=n  ; i++){
        printf("enter ele in non decresing order : ");
        scanf("%d ",&w[i]);
        
        total_sum += w[i];
    }
    
    
    

    return 0;
}
#include <stdio.h>
#include <conio.h>


NextValue(k){
    x[k ]= x[k]+1  % (n+1);

    if( x[k] == 0) return ;

    if( g[x[k]][x[k-1]] !=0){
        for (int j = 1 ; j<=n ; j++)    
               if( x[j] == x[k]) break;

        if( j == k){
            if ( k==n || ( k<n  && G[x[n]][x[1]] != 0 ))  return ;
        }
    }
}
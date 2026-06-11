#include <stdio.h>
#include <conio.h>

int  linear( int arr[] , int n, int key )
{
   for(int i  = 1;i<=n ; i++){
    if(arr[i] == key) return i;
   }

   return -1;
}

int  binaryS( int arr[], int n, int key ){
    int low = 1 , high = n ; 

    while( low <= high){
        int mid = (low + high)/2;

        if( arr[mid] == key) return mid;
        else if( arr[mid] > key)  high = mid -1;
        else if( arr[mid] < key  ) low = mid + 1 ;
    }

    return -1;
}

int main(){
   int n , arr[20], key;
   printf(" Enter size of array : - ");
   scanf("%d",&n);
   printf("enter Key ro search : ");
   scanf("%d", &key);
   printf("Enter array ele : - ");
   for(int i = 1 ; i <=n ; i++){
    scanf("%d",&arr[i]);
   }

   int res = binaryS(arr, n, key);
   if( res==-1) printf("not found");
   else   printf(" idx : %d",res);
    return 0;
}
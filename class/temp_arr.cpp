#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

template <class T>
void SelectionS(T arr[]){
  for(int i = 0 ;i<n-1; i++){
    int minidx = i ;
    for(int j = i+1 ;j<n; j++){
        if(arr[minidx]> arr[j]){
            minidx = j ;
        }
    }

    if(i!=minidx){
        T temp = arr[i];
        arr[i] = arr[minidx];
        arr[minidx] = temp;
    }
  }
}

int main(){
    int arr[10],n;
    
    cout<<"enter no.of ele : ";
    cin>>n ;
    SelectionS(arr);

    return 0 ;
}
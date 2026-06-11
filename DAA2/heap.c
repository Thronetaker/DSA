#include<stdio.h>
#define MAX 100
int a[MAX];
int n;
void heapify();
void adjust(int i){
    int j, temp;
    j=i*2;
    temp=a[i];
    while(j<=n){
        if(j<n && a[j]<a[j+1]){
            j=j+1;
        }
        if(temp>a[j])break;
        a[j/2]=a[j];
        j*=2;
    }
    a[j/2]=temp;
}
void insert(int val){
    n++;
    a[n]=val;
    int i=n;
    while(i>1 && a[i/2]<a[i]){
        int temp=a[i];
        a[i]=a[i/2];
        a[i/2]=temp;
        i/=2;
    }
}
void heapify(){
    int i;
    for(i=n/2; i>=1; i--){
        adjust(i);
    }
}
void delete(){

    int temp=a[1];
    a[1]=a[n];
    n--;
    heapify();
    printf("val deleted: ");
    printf("%d", temp);

}
int main(){
    int i, val;
    printf("enter the number of elements: ");
    scanf("%d", &n);
    printf("enter the elements: ");
    for(i=1; i<=n; i++){
        scanf("%d", &a[i]);
    }
    heapify();
    for(i=1; i<=n; i++){
        printf("%d ", a[i]);
    }
    printf("\n");
    printf("to insert element in heap \n enter its val : ");
    scanf("%d", &val);
    
    insert( val);
    for(i=1; i<=n; i++){
        printf("%d ", a[i]);
    }
    printf("\n");
    //a[1]=max
    printf("now delteing the max value");
    delete();
    printf("\n");
     for(i=1; i<=n; i++){
        printf("%d ", a[i]);
    }
    printf("\n");
}
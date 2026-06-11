

void part_first(a,low,high){
    p = a[i];  i = low  j = high 

    do{
        do{
            i++;
        }while(a[i] < p);

        do{
            j--;
        }while(a[j] > p);

        if(i<j){
            swap(a[i], a[j])
        }

    }while(1);

    swap(p , a[low]);
    return i ;
}
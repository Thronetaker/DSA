 


 int sFind(int r ){
    while( p[r] >= 0)   r = p[r];

    return r ;
 }

 int CollapseFind(int i){
    r = i ;
    while( p[r] > 0) r = p[r];

    while (i!= r){
        s = p[i];
        p[i] = r;
        i = s ;
    }

    return r ;
 }


 void sUnion(int i , int j ){
    p[i] = j ;
 }


 void WeightedUnion(){

    temp = p[i] + p[j];

    if(p[i] > p[j]){
        p[i] = j;
        p[j] = temp;
    }else{
         p[j] = i;
        p[i] = temp;
    }
 }


 int main(){

    int i = sFind(u);
    int j = sFind(v);
    if( i!=j){
        sUnion(u , v );
    }else{
        printf("Cant unite");
    }
 }
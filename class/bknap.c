#include <stdio.h>


int w[] = {0,11,12,8,7,9};
int p[] = {0,23,24,15,13,16};
int n =5 ;
int x[] ={0,0,0,0,0,0};
int y[] = {0,0,0,0,0,0};
int m = 26;
int fp = 0;
int fw = 0 ;

int Bound(int cp,int cw , int k ){
	int b,c;
	b = cp;
	c =cw;
	
	for(int i = k;i<=n ;i++){
		c = c+w[i];
		if(c<m){
			b = b+ p[i];
		}else{
			return b+(1-(c-m)/w[i]) * p[i];
		}
	}
	
	return b ;
}

void Bknap(int k, int cp, int cw){
	//Generate left child   ->included
   //    cp = current profit  ; cw = curr weigth ;fp = final profit
	int j;
	
	
	if(cw + w[k] <= m){
		y[k] = 1;
		
		if(k<n) {
			printf("line 37 ->  k : %d ",k);
			printf("\n");
			Bknap(k+1,cp + p[k], cw + w[k]);
		}
		   
		   
		
		if(cp + p[k] > fp  && k==n){
			fp = cp + p[k];
			fw = cw + w[k];
			
			for(j = 1; j<=k;j++){ 
			     x[j] = y[j];
			}
		}
	}
	
	
//	Generate right child ->excluded

    if(Bound (cp, cw,k) >= fp){
    	y[k] = 0;
    	if(k<n)
    	    Bknap(k+1,cp,cw);
    	    
    	if( cp> fp && k==n){
    		fp = cp;
    		fw = cw;
    		
    		for(j =1 ;j<= k ;j++){
    			x[j] = y[j];
			}
		}
	}
}




int main(){
	
	Bknap(1,0,0);
	
	for(int i = 1;i<=n;i++){
		printf("%d ",x[i] );
	}
	return 0 ;
}
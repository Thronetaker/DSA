void djik(){
    // v is starting vertex 
    int v , u;

    for(int i = 0 ; i<= n ; i++){
        s[i] = false; //initialise
        dist[i] = cost[v][i]; // starting vertex ka hr vertes se dist 
    }

    s[v] = true;
    dist[v] = 0.0;

    //chose a u vertex with min dist /cost

    for(int i = 2 ; i< n-1 ; i++){
        int min = 999;

        //find min w 
        for(int i = 1 ; i <=n ; i++){                 // yd rkhpoooo
            i( s[i] == false && dist[i]<min){
                min = dist[i];
                u = i ;
            }
        }

        s[u ] = true;

        for( int w = 1 ; w<=n ; w++ ){
            if (s[w] == 0 && cost[u][w] != 999) {    /// yaad rkhoo 
                if (dist[w] > dist[u] + cost[u][w]) {
                    dist[w] = dist[u] + cost[u][w];
                }
            }
    }

    
}
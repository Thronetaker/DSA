class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);

        for(int i =1 ;i<n ;i++){
            // array => 0,1 idx
            int lstInterval[] = res.get( res.size()-1);


            // lstInterval ending time greater than starting time of curr interval
            // lstInterval ending time smaller than ending time of curr interval 
            // changee the ending time of lstInterval to ending time of curr interval
            if( lstInterval[1] >= intervals[i][0] &&  lstInterval[1] <= intervals[i][1]){
                lstInterval[1] = intervals[i][1];
                // it will reflect change in the res automatially REFERENCES 
            }
            else if(lstInterval[1] < intervals[i][0]){
                // list added 
                res.add(intervals[i]);
            }

        }

        return res.toArray( new int[res.size()][]) ;
    }
}
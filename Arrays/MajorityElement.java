class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int cnt = 1;

        for(int i =1 ;i <nums.length;i++){
            if(nums[i] == maj){
                cnt++;
            }else{
                cnt--;
                if(cnt == 0){
                    maj = nums[i];
                    cnt = 1;
                }
            }
        }
       cnt =0;
        for(int num: nums){
            if(num == maj ){
                cnt++;
            }
        }

        if(cnt > (nums.length/2))  {
             return maj ;
        }else{
            return -1;
        }
        
    }
}
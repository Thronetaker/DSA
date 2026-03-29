class Solution {
    public void swap(int[] nums, int start , int end){
        int temp = nums[start];
        nums[start] =nums[end];
        nums[end] = temp;
    }

    public void reverse(int[] nums, int start , int end){
        while(start< end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // find pivot 
        for(int i= n-2 ;i>=0 ;i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        
        // if in decreasing order  return after  reverse
        if(pivot == -1){
            reverse(nums, 0,n-1);
            return;
        }
        
        // if pivot!= -1
        // swap pivot ele with the first greatestt to it from last ele
        for(int i = n-1 ;i>pivot ;i--){
            if(nums[i] > nums[pivot]){
                swap(nums, pivot,i);
                break;
            }
        }

        // now array in decreasing order from pivot+1 idx to end 
        reverse(nums, pivot+1, n-1);
        return ;
    }
}
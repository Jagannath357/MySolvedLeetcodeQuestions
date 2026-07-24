class Solution {
    public int findLHS(int[] nums) {
        //sort the array
        Arrays.sort(nums);

        //expand window
        int n = nums.length;
        int i = 0, j = 0, maxLength = 0;
        for(j = 0; j < n; j++){
            //shrink the window
            while(nums[j] - nums[i] > 1){
                i++;
            }
            if(nums[j] - nums[i] == 1){
                maxLength = Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }
}
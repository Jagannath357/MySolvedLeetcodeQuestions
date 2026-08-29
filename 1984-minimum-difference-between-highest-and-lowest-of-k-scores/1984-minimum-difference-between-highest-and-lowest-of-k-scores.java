import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || n < k) return 0;

        Arrays.sort(nums);
        int i = 0, j = k-1, minDiff = Integer.MAX_VALUE;
        minDiff = nums[j] - nums[i];
        while(j < n){
            if(minDiff > nums[j] - nums[i]){
                minDiff = nums[j] - nums[i];
            }
            i++;
            j++;
        }

        return minDiff;
    }
}
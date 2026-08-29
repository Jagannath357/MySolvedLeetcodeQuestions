// import java.util.Arrays;

// class Solution {
//     public int minimumDifference(int[] nums, int k) {
//         int n = nums.length;
//         if(n == 0 || n < k) return 0;

//         Arrays.sort(nums);
//         int i = 0, j = k-1, minDiff = Integer.MAX_VALUE;
//         minDiff = nums[j] - nums[i];
//         while(j < n){
//             if(minDiff > nums[j] - nums[i]){
//                 minDiff = nums[j] - nums[i];
//             }
//             i++;
//             j++;
//         }

//         return minDiff;
//     }
// }

import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        // Base case check
        if (nums == null || nums.length < k) return 0;

        // 1. Sort to bring closest elements together
        Arrays.sort(nums);
        
        int minDiff = Integer.MAX_VALUE;
        
        // 2. Sliding window of size k
        for (int i = 0; i <= nums.length - k; i++) {
            int currentDiff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, currentDiff);
        }
        
        return minDiff;
    }
}

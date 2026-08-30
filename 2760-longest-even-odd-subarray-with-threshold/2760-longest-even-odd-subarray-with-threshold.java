class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLength = 0;
        int chainCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Rule 3 Violation: If the value exceeds threshold, no chain can exist/continue here
            if (nums[i] > threshold) {
                chainCount = 0; 
            } 
            // Rule 2 Check: If a chain is already running, check if it alternates with the previous item
            else if (chainCount > 0 && nums[i] % 2 != nums[i - 1] % 2) {
                chainCount++;
            } 
            // Rule 1 Check: If the chain broke or hasn't started, check if this element can start a fresh chain
            else if (nums[i] % 2 == 0) {
                chainCount = 1;
            } 
            // Default Case: Odd number trying to start a chain when chainCount is 0
            else {
                chainCount = 0;
            }
            
            // Continuously update the maximum length seen so far
            maxLength = Math.max(maxLength, chainCount);
        }
        
        return maxLength;
    }
}

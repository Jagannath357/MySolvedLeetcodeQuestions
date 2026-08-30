class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int maxLength = 0, chainCount = 0;
        int i = 0;
        boolean found = false;
        boolean isEven = false;
        while(i < n){
            
            if(found){
                if(isEven){
                    if(nums[i] % 2 != 0 && nums[i] <= threshold){
                        chainCount++;
                        isEven = false;
                    }else{
                        found = false;
                        maxLength = Math.max(maxLength, chainCount);
                        chainCount = 0;
                        if(nums[i] % 2 == 0 && nums[i] <= threshold){
                            chainCount = 1;
                            isEven = true;
                            found = true;
                        }
                    }
                }else{
                    if(nums[i] % 2 == 0 && nums[i] <= threshold){
                        chainCount++;
                        isEven = true;
                    }else{
                        found = false;
                        maxLength = Math.max(maxLength, chainCount);
                        chainCount = 0;
                        if(nums[i] % 2 == 0 && nums[i] <= threshold){
                            chainCount = 1;
                            isEven = true;
                            found = true;
                        }
                    }
                }
            }else{
                chainCount = 0;
                if(nums[i] % 2 == 0 && nums[i] <= threshold){
                    chainCount++;
                    found  = true;
                    isEven = true;
                }else{
                    maxLength = Math.max(maxLength, chainCount);
                }
            }
            i++;
        }
        maxLength = Math.max(maxLength, chainCount);
        return maxLength;
    }
}
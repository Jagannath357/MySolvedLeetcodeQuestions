import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || n < k) return 0;

        Arrays.sort(nums);
        int i = 0, j = k-1, minDiff = 0;
        int m = 0;
        int maxIdx = -1, minIdx = -1, maxEle = Integer.MIN_VALUE, minEle = Integer.MAX_VALUE;
        while(m < k){
            if(nums[m] > maxEle){
                maxEle = nums[m];
                maxIdx = m;
            }
            if(nums[m] < minEle){
                minEle = nums[m];
                minIdx = m;
            }
            m++;
        }
        minDiff = maxEle - minEle;
        while(j < n){
            if(maxIdx < i || minIdx < i){
                m = i;
                maxEle = Integer.MIN_VALUE;
                minEle = Integer.MAX_VALUE;
                while(m <= j){
                    if(nums[m] > maxEle){
                        maxEle = nums[m];
                        maxIdx = m;
                    }
                    if(nums[m] < minEle){
                        minEle = nums[m];
                        minIdx = m;
                    }
                    m++;
                }
            }
            if(minDiff > maxEle - minEle){
                minDiff = maxEle-minEle;
            }

            if(j == n-1) return minDiff;

            if(nums[j+1] > maxEle){
                maxEle = nums[j+1];
            }
            if(nums[j+1] < minEle){
                minEle = nums[j+1];
            }
            i++;
            j++;
        }

        return minDiff;
    }
}
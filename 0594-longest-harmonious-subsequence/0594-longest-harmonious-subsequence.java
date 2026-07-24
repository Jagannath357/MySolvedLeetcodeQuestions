import java.util.Map;
import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> subcequence = new HashMap<>();
        int i, j, maxLength = 0;
        for(int num : nums){
            subcequence.put(num, subcequence.getOrDefault(num, 0) + 1);
        }
        for(int key : subcequence.keySet()){
            if(subcequence.containsKey(key + 1)){
                maxLength = Math.max(maxLength, subcequence.get(key) + subcequence.get(key + 1));
            }
        }
        return maxLength;
    }
}
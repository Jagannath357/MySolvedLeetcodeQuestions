class Solution {
    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int count = 0;
        int n = numStr.length();
        for(int i = 0; i <= n - k; i++){
            String subStr = numStr.substring(i, i+k);
            int subNum = Integer.parseInt(subStr);
            if(subNum != 0 && num % subNum == 0){
                count++;
            }
        }
        return count;
    }
}
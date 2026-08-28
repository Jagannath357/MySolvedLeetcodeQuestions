class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        char[] strArr = s.toCharArray();
        int n = strArr.length;
        int i = 0, j = i+2;
        if(n < 3){
            return 0;
        }
        while(j < n){
            if(strArr[i] != strArr[i+1] && strArr[i] != strArr[j] && strArr[i+1] != strArr[j]){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}
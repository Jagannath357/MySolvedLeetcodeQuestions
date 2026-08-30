class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minWhite = Integer.MAX_VALUE;
        int n = blocks.length();
        char[] arr = blocks.toCharArray();
        int i = 0, j = i+k-1, m;
        int wCount = 0;
        while(j < n){
            m = i;
            wCount = 0;
            while(m <= j){
                if(arr[m] == 'W') wCount++;
                m++;
            }
            if(minWhite > wCount) minWhite = wCount;
            i++;
            j++;
        }
        return minWhite;
    }
}
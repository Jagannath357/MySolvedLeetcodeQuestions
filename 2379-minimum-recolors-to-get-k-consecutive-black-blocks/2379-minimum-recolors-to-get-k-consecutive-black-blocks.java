class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wCount = 0;
        int n = blocks.length();
        
        // 1. Count 'W' blocks in the very first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                wCount++;
            }
        }
        
        // Initialize our minimum with the first window's count
        int minWhite = wCount;
        
        // 2. Slide the window across the rest of the string
        for (int i = k; i < n; i++) {
            // Add incoming character on the right
            if (blocks.charAt(i) == 'W') {
                wCount++;
            }
            // Remove outgoing character from the left
            if (blocks.charAt(i - k) == 'W') {
                wCount--;
            }
            
            // Keep track of the minimum operations found so far
            minWhite = Math.min(minWhite, wCount);
        }
        
        return minWhite;
    }
}

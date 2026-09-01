class Solution {
    public int getSum(int n){
        int l = String.valueOf(n).length();
        int sum = 0, rem = 0;
        while(n != 0){
            rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        int slow = n;
        int fast = getSum(n);
        while(fast != 1 && slow != fast){
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return fast == 1;
    }
}
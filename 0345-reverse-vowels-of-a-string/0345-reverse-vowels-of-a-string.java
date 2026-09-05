class Solution {
    public String reverseVowels(String s) {
        char[] chStr = s.toCharArray();
        int n = chStr.length;
        int i = 0, j = n-1;
        while(i < j){
            String vowels = "aeiouAEIOU";
            boolean leftVowel = vowels.contains(chStr[i]+"");
            boolean rightVowel = vowels.contains(chStr[j]+"");
            if(leftVowel && rightVowel){
                char temp = chStr[i];
                chStr[i] = chStr[j];
                chStr[j] = temp;
                i++;
                j--;
            }
            else if(leftVowel) j--;
            else i++;
        }
        String ans = "";
        for(int k = 0;k < n; k++){
            ans = ans + chStr[k];
        }
        return ans;
    }
}
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void traverseInorder(TreeNode root, Map<Integer, Integer> modeFreq){
        if(root == null){
            return;
        }

        traverseInorder(root.left, modeFreq);
        modeFreq.put(root.val, modeFreq.getOrDefault(root.val, 0) + 1);
        traverseInorder(root.right, modeFreq);
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> modeFreq = new HashMap<>();
        traverseInorder(root, modeFreq);
        
        int maxFreq = 0;
        for(int freq : modeFreq.values()){
            maxFreq = Math.max(freq, maxFreq);
        }

        List<Integer> modeList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : modeFreq.entrySet()){
            if(entry.getValue() == maxFreq){
                modeList.add(entry.getKey());
            }
        }
        int[] result = new int[modeList.size()];
        for(int i = 0; i < modeList.size(); i++){
            result[i] = modeList.get(i);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}







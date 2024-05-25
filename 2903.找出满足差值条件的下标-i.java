/*
 * @lc app=leetcode.cn id=2903 lang=java
 *
 * [2903] 找出满足差值条件的下标 I
 */

// @lc code=start
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+indexDifference;j<n;j++){
                if(Math.abs(nums[i]-nums[j])>=valueDifference){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
// @lc code=end


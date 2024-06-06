/*
 * @lc app=leetcode.cn id=3038 lang=java
 *
 * [3038] 相同分数的最大操作数目 I
 */

// @lc code=start
class Solution {
    public int maxOperations(int[] nums) {
        int ans=1;
        int sum=nums[0]+nums[1];
        for(int i=2;i<nums.length-1;i+=2){
            if(nums[i]+nums[i+1]==sum){
                ans++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}
// @lc code=end


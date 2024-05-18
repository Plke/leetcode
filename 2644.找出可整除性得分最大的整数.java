/*
 * @lc app=leetcode.cn id=2644 lang=java
 *
 * [2644] 找出可整除性得分最大的整数
 */

// 双重循环

// @lc code=start
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int n=nums.length,m=divisors.length;
        int ans=0;
        int max=-1;//让没有被整除的情况下，ans有值
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[j]%divisors[i]==0)count++;
            }
            if(count>max||(count==max&&divisors[i]<ans)){
                ans=divisors[i];
                max=count;
            }
        }
        return ans;
    }
}
// @lc code=end


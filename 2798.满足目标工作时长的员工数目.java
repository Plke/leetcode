/*
 * @lc app=leetcode.cn id=2798 lang=java
 *
 * [2798] 满足目标工作时长的员工数目
 */

// @lc code=start
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res=0;
        for(int i=0;i<hours.length;i++){
            if(hours[i]>=target) res++;
        }
        return res;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1953 lang=java
 *
 * [1953] 你可以工作的最大周数
 */

// 贪心
// longest<=rest+1 就可以完成，rest为剩下所有任务

// @lc code=start
class Solution {
    public long numberOfWeeks(int[] milestones) {
        long  count=0;
        int max=milestones[0];
        for(int i:milestones){
            if(i>max){
                max=i;
            }
            count+=i;
        }
        count-=max;
        if(max>=count+1){
            return count*2+1;
        }
        return max+count;

    }
}
// @lc code=end


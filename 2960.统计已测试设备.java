/*
 * @lc app=leetcode.cn id=2960 lang=java
 *
 * [2960] 统计已测试设备
 */

// 很简单
// 当前统计的数量就是，要减少的电量

// @lc code=start
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int n=batteryPercentages.length;
        int ans=0;
        for(int i=0;i<n;i++){
            batteryPercentages[i]-=ans;
            if(batteryPercentages[i]>0){
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end


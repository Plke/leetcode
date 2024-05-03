/*
 * @lc app=leetcode.cn id=1491 lang=java
 *
 * [1491] 去掉最低工资和最高工资后的工资平均值
 */

// @lc code=start
class Solution {
    public double average(int[] salary) {
        int min=salary[0],max=salary[0],sum=0;
        for(int i=0;i<salary.length;i++){
            if(salary[i]>max) max=salary[i];
            if(salary[i]<min) min=salary[i];
            sum+=salary[i];
        }
        return (double)(sum-max-min)/(salary.length-2);
    }
}
// @lc code=end


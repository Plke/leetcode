/*
 * @lc app=leetcode.cn id=2079 lang=java
 *
 * [2079] 给植物浇水
 */

// 一次遍历
// 维护一个当前剩余的水
// 剩的水够就像前一步
// 不够就返回，在返回


// @lc code=start
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int ans=0;
        int curCap=capacity;
        for(int i=0;i<plants.length;i++){
            if(curCap>=plants[i]){
                ans++;
                curCap-=plants[i];
            }
            else{
                ans+=(2*i+1);
                curCap=capacity-plants[i];
            }
        }
        return ans;
    }
}
// @lc code=end


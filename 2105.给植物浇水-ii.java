/*
 * @lc app=leetcode.cn id=2105 lang=java
 *
 * [2105] 给植物浇水 II
 */

// 简单模拟，从两边分别开始，最后判断是否会共同浇同一个植物

// @lc code=start
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans=0;
        int a=capacityA,b=capacityB;
        int i=0,j=plants.length-1;
        while(i<j){
            if(a>=plants[i]){ 
                a-=plants[i];
            }
            else{
                ans++;
                a=capacityA-plants[i];
            }
            if(b>=plants[j]){
                b-=plants[j];
            }
            else{
                ans++;
                b=capacityB-plants[j];
            }
            i++;
            j--;
        }
        if(i==j){
            if(Math.max(a,b)>=plants[i]);
            else ans++;
        }
        return ans;
    }
}
// @lc code=end


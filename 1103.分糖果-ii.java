/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */
// 暴力
// @lc code=start
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int curpos = 0;
        int curcan = 1;
        while (candies > 0) {
            if (curpos == num_people) {
                curpos = 0;
            }
            if (curcan >= candies) {
                break;
            }
            candies -= curcan;
            ans[curpos++] += curcan++;
        }
        ans[curpos] += candies;
        return ans;
    }
}
// @lc code=end


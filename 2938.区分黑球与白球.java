/*
 * @lc app=leetcode.cn id=2938 lang=java
 *
 * [2938] 区分黑球与白球
 */
// 贪心

// @lc code=start
class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                sum++;
            } else {
                ans += sum;
            }
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=2028 lang=java
 *
 * [2028] 找出缺失的观测数据
 */


// 求出剩余的和
// 判断剩余的和是否在[n, 6n]范围内
// 把和平均分，剩余余数再分

// @lc code=start
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];
        int m = rolls.length;
        int sum = mean * (n + m);
        for (int k : rolls) {
            sum -= k;
        }
        if (sum < n || sum > 6 * n) {
            return new int[0];
        }

        int q = sum / n, rem = sum % n;
        for (int i = 0; i < n; i++) {
            ans[i] = q + (i < rem ? 1 : 0);
        }
        return ans;
    }
}
// @lc code=end


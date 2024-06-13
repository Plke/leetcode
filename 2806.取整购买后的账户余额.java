/*
 * @lc app=leetcode.cn id=2806 lang=java
 *
 * [2806] 取整购买后的账户余额
 */

// @lc code=start
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount + 5) / 10 * 10;
    }
}
// @lc code=end


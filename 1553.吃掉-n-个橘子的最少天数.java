/*
 * @lc app=leetcode.cn id=1553 lang=java
 *
 * [1553] 吃掉 N 个橘子的最少天数
 */

// 使用哈希记忆递归
// 使用递归实现递推式
// 为了减少操作-1的次数，尽量凑除法操作

// @lc code=start
class Solution {

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minDays(int n) {
        if (n <= 2) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
       
        memo.put(n, Math.min(n % 2 +  minDays(n / 2) + 1, n % 3  + minDays(n / 3)+ 1));

        // memo.put(n, Math.min(Math.min(minDays(n / 2) + 1,  minDays(n / 3)+ 1) , minDays(n - 1) + 1));
        System.out.println(memo);
        return memo.get(n);
    }
}
// @lc code=end


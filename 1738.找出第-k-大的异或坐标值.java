/*
 * @lc app=leetcode.cn id=1738 lang=java
 *
 * [1738] 找出第 K 大的异或坐标值
 */

// 异或特性，新的矩阵，记录每个i，j，之前所有结果的异或值
// 排序

// @lc code=start
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                dp[i][j] = matrix[i-1][j-1] ^ dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1];
                list.add(dp[i][j]);
            }
        }
        list.sort((a, b) -> b - a);
        System.out.println(list);
        return list.get(k - 1);
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=3040 lang=java
 *
 * [3040] 相同分数的最大操作数目 II
 */

// @lc code=start
class Solution {
    int[] nums;
    int[][] map;

    public int maxOperations(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.map = new int[n][n];
        int res = 0;

        res = Math.max(res, helper(0, n - 1, nums[0] + nums[n - 1]));
        res = Math.max(res, helper(0, n - 1, nums[0] + nums[1]));
        res = Math.max(res, helper(0, n - 1, nums[n - 2] + nums[n - 1]));
        return res;
    }

    public int helper(int i, int j, int target) {
        for (int k = 0; k < nums.length; k++) {
            Arrays.fill(map[k], -1);
        }
        return dfs(i, j, target);
    }

    public int dfs(int i, int j, int target) {
        if (i >= j) {
            return 0;
        }
        if (map[i][j] != -1) {
            return map[i][j];
        }
        int ans = 0;
        if (nums[i] + nums[i + 1] == target) {
            ans = Math.max(ans, dfs(i + 2, j, target) + 1);
        }
        if (nums[j - 1] + nums[j] == target) {
            ans = Math.max(ans, dfs(i, j - 2, target) + 1);
        }
        if (nums[i] + nums[j] == target) {
            ans = Math.max(ans, dfs(i + 1, j - 1, target) + 1);
        }
        map[i][j] = ans;
        return ans;
    }

}
// @lc code=end


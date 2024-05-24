/*
 * @lc app=leetcode.cn id=1673 lang=java
 *
 * [1673] 找出最具竞争力的子序列
 */

// 为了使小的数字尽量靠前
// 单调栈，当当前栈内元素数量大于k，并且，栈顶元素大于当前元素，就弹栈，然后加入当前元素

// @lc code=start
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        List<Integer> stack = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && n - i + stack.size() > k && stack.getLast() > nums[i]) {
                stack.removeLast();
            }
            stack.addLast(nums[i]);
        }
        int[] ans = new int[k];
        while (stack.size() > k) {
            stack.removeLast();
        }
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = stack.removeLast();
        }
        return ans;
    }
}
// @lc code=end


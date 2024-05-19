/*
 * @lc app=leetcode.cn id=1535 lang=java
 *
 * [1535] 找出数组游戏的赢家
 */

// 模拟
// 为了防止k过大，在模拟完整个数组,还没出结果，那就一定可以确定最大值为答案

// @lc code=start
class Solution {
    public int getWinner(int[] arr, int k) {
        int ans = arr[0];
        int count = 0;
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int x = 0;
        while (k != count && x <  n) {
            x++;
            int a = queue.poll();
            if (a > ans) {
                ans = a;
                count = 1;
                queue.add(ans);
            } else {
                queue.add(a);
                count++;
            }
        }
        return ans;
    }
}
// @lc code=end


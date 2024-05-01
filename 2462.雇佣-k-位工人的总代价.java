/*
 * @lc app=leetcode.cn id=2462 lang=java
 *
 * [2462] 雇佣 K 位工人的总代价
 */

//解题思路：模拟，
// 1、使用优先队列收集符合条件的数据（即前最前面 candidates 和最后面 candidates），保存数据及其索引
// 2、遍历优先队列，取出 k 个数据，并累加代价，同时根据索引选择添加新的数据

// @lc code=start
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> peo = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else
                return a[0] - b[0];
        });
        int n = costs.length;
        int left = candidates - 1;
        int right = n - candidates;
        if (left + 1 < right) {
            for (int i = 0; i <= left; ++i) {
                peo.offer(new int[] { costs[i], i });
            }
            for (int i = right; i < n; ++i) {
                peo.offer(new int[] { costs[i], i });
            }
        } else {
            for (int i = 0; i < n; ++i) {
                peo.offer(new int[] { costs[i], i });
            }
        }
        long res = 0;

        for (int i = 0; i < k; ++i) {
            int[] cur = peo.poll();
            int id = cur[1];
            res += cur[0];
            if (left + 1 < right) {
                if (id <= left) {
                    left++;
                    peo.offer(new int[] { costs[left], left });
                } else {
                    right--;
                    peo.offer(new int[] { costs[right], right });
                }
            }
        }
        return res;
    }
}
// @lc code=end


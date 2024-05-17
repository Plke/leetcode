/*
 * @lc app=leetcode.cn id=826 lang=java
 *
 * [826] 安排工作以达到最大收益
 */

// 首先按照难度对工作进行排序
// 工人按能力排序
// 遍历工人，同时一个指针指向当前任务，也记录之前所有任务中的最大收益
// 如果当前工人能力大于等于当前任务的难度，并且大于下一个任务，则指向下一个任务
// 如果当前符合条件则累加最大收益

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        Arrays.sort(worker);
        int cur = 0;
        int ans = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (jobs[cur][1] > max) {
                max = jobs[cur][1];
            }
            while (cur < n && worker[i] >= jobs[cur][0] && cur + 1 < n && worker[i] >= jobs[cur + 1][0]) {
                cur++;
                if (jobs[cur][1] > max) {
                    max = jobs[cur][1];
                }
            }
            if (cur >= n) {
                return ans;
            }
            if (worker[i] < jobs[cur][0]) {
                continue;
            }
            ans += max;
        }
        return ans;
    }
}
// @lc code=end


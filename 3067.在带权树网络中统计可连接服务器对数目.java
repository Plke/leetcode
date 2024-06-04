/*
 * @lc app=leetcode.cn id=3067 lang=java
 *
 * [3067] 在带权树网络中统计可连接服务器对数目
 */

// 对于每个结点都进行一次遍历，深搜当前分支上符合的结点的个数
// 更具排列组合计算，加到答案

// @lc code=start
class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int[] e : graph[i]) {
                int cnt = dfs(i, e[0], e[1] % signalSpeed, signalSpeed, graph);
                ans[i] += pre * cnt;
                pre += cnt;
            }
        }
        return ans;
    }

    private int dfs(int root, int next, int cur, int signalSpeed, List<int[]>[] graph) {
        int res = 0;
        if (cur == 0) {
            res++;
        }
        for (int[] e : graph[next]) {
            int v = e[0];
            int cost = e[1];
            if (v != root) {
                res += dfs(next, v, (cur + cost) % signalSpeed, signalSpeed, graph);
            }
        }
        return res;
    }
}
// @lc code=end


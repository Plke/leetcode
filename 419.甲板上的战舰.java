/*
 * @lc app=leetcode.cn id=419 lang=java
 *
 * [419] 甲板上的战舰
 */

// @lc code=start
class Solution {
    private int[][] visited;
    int n, m;

    private void dfs(char[][] board, int i, int j) {
        if (i + 1 < m && board[i + 1][j] == 'X') {
            visited[i + 1][j] = 1;
            dfs(board, i + 1, j);
        }
        if (j + 1 < n && board[i][j + 1] == 'X') {
            visited[i][j + 1] = 1;
            dfs(board, i, j + 1);
        }
    }

    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'X') {
                    visited[i][j] = 1;
                    dfs(board, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end


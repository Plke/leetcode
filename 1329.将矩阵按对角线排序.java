/*
 * @lc app=leetcode.cn id=1329 lang=java
 *
 * [1329] 将矩阵按对角线排序
 */

// @lc code=start
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        List<List<Integer>> list = new ArrayList<>(n + m - 1);
        for (int i = 0; i < n + m; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.get(i - j + m).add(mat[i][j]);
            }
        }
        for (List<Integer> l : list) {
            Collections.sort(l,(a,b)->b-a);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j]=list.get(i - j + m).removeLast();
            }
        }
    return mat;
    }
}
// @lc code=end


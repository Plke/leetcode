/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] 拆炸弹
 */

// 首先在code在拼接一个code
// 然后使用滑动窗口

// @lc code=start
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[] res=new int[n];
        int[] newCode = new int[n * 2];
        for(int i=0;i<n;i++){
            newCode[i]=code[i];
            newCode[i+n]=code[i];
        }
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        //第一个窗口
        for (int i = l; i <= r; i++) {
            w += newCode[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= newCode[l];
            w += newCode[r + 1];
            l++;
            r++;
        }
        return res;
    }
}
// @lc code=end


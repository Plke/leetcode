/*
 * @lc app=leetcode.cn id=2981 lang=java
 *
 * [2981] 找出出现至少三次的最长特殊子字符串 I
 */

// 统计每个字母连续出现的长度，同时只保留前三个最长的长度
// 结果有三种情况
// 1、结果全来自于最长的那个，ans=n0-2
// 2、结果来自于最长的和第二长的 ans=n1-1
// 3、结果来自于最长的、第二长的和第三长的 ans=n2

// @lc code=start
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        List<Integer>[] chs = new List[26];
        for (int i = 0; i < 26; i++) {
            chs[i] = new ArrayList<Integer>();
        }
        int ans = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            if (i + 1 == n || s.charAt(i) != s.charAt(i + 1)) {
                int ch = s.charAt(i) - 'a';
                chs[ch].add(cnt);
                cnt = 0;
                for (int j = chs[ch].size() - 1; j > 0; j--) {
                    if (chs[ch].get(j) > chs[ch].get(j - 1)) {
                        Collections.swap(chs[ch], j, j - 1);
                    } else {
                        break;
                    }
                }
                if (chs[ch].size() > 3) {
                    chs[ch].remove(chs[ch].size() - 1);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i].size() > 0 && chs[i].get(0) > 2) {
                ans = Math.max(ans, chs[i].get(0) - 2);
            }
            if (chs[i].size() > 1 && chs[i].get(0) > 1) {
                ans = Math.max(ans, Math.min(chs[i].get(0) - 1, chs[i].get(1)));
            }
            if (chs[i].size() > 2) {
                ans = Math.max(ans, chs[i].get(2));
            }
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=2982 lang=java
 *
 * [2982] 找出出现至少三次的最长特殊子字符串 II
 */

// 和2981一样

// @lc code=start
class Solution {
    public int maximumLength(String s) {
        List<Integer>[] list = new List[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); i++) {
            int cnt = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                cnt++;
            }
            int ch = s.charAt(i) - 'a';
            list[ch].add(cnt);
            for (int j = list[ch].size() - 1; j > 0; j--) {
                if (list[ch].get(j) > list[ch].get(j - 1)) {
                    Collections.swap(list[ch], j, j - 1);
                } else {
                    break;
                }
            }
            if (list[ch].size() > 3) {
                list[ch].remove(3);
            }
        }
        int ans = -1;
        for (int i = 0; i < 26; i++) {
            if (list[i].size() > 0 && list[i].get(0) > 2) {
                ans = Math.max(ans, list[i].get(0) - 2);
            }
            if (list[i].size() > 1 && list[i].get(0) > 1) {
                ans = Math.max(ans, Math.min(list[i].get(0) - 1, list[i].get(1)));
            }
            if (list[i].size() > 2) {
                ans = Math.max(ans, list[i].get(2));
            }
        }
        return ans;
    }
}
// @lc code=end


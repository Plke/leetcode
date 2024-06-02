/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// 可以使用set

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : candyType) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        int ans = 0;
        for (Integer set : map.keySet()) {
            ans++;
        }
        if (ans > candyType.length / 2) {
            return candyType.length / 2;
        }
        return ans;
    }
}
// @lc code=end


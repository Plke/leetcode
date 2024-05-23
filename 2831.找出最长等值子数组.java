/*
 * @lc app=leetcode.cn id=2831 lang=java
 *
 * [2831] 找出最长等值子数组
 */

// @lc code=start
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums.get(0), 1);
        int count = 0;
        int tag = nums.get(0);
        while (right < n) {
            if (count < k) {
                int value = nums.get(right);
                if (value == tag) {
                    map.put(value, map.get(value) + 1);
                } else {
                    count++;
                    map.put(value, map.getOrDefault(value, 0) + 1);
                    if (count > k) {
                        map.put(nums.get(left), map.get(left) - 1);
                        left++;
                        if (tag != nums.get(left)) {
                            count--;
                        }
                    } else {
                        right++;
                    }
                }
            } else {

            }
        }
        return map.get(tag);
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=3072 lang=java
 *
 * [3072] 将元素分配到两个数组中 II
 */

// 纯暴力

// @lc code=start
class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            int k = nums[i];
            int count1 = greaterCount(arr1, k);
            int count2 = greaterCount(arr2, k);
            if (count1 > count2) {
                arr1.add(k);
            } else if (count1 < count2) {
                arr2.add(k);
            } else {
                if (arr1.size() <= arr2.size()) {
                    arr1.add(k);
                } else {
                    arr2.add(k);
                }
            }

        }
        System.out.println(arr1);
        System.out.println(arr2);
        int i = 0;
        for (int k : arr1) {
            ans[i++] = k;
        }

        for (int k : arr2) {
            ans[i++] = k;
        }
        return ans;
    }

    private int greaterCount(List<Integer> arr, int val) {
        int count = 0;
        for (int k : arr) {
            if (k > val) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end


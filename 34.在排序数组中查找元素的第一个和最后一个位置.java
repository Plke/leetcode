/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */


//二分查找
// 把找左边和找右边分开

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearch1(nums, target);
        result[1] = binarySearch2(nums, target);
        if(nums.length==0||nums[result[0]] != target){
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }
    // 返回第一个为目标的值的索引
    public static int binarySearch1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = ( right + left ) / 2;
            if(arr[mid] >= target){
              right=mid-1;
              ans=mid;
            }
            else{
                left=mid+1;
            }
        }
        return  ans;          
    }
    // 返回最后一个为目标的值的索引
    public static int binarySearch2(int[] arr, int target) {
      int left = 0;
      int right = arr.length - 1;
      int ans = 0;
      while (left <= right) {
          int mid = ( right + left ) / 2;
          if(arr[mid] <= target){
              left=mid+1;
              ans=mid;
          }
          else{
              right=mid-1;
          }
      }
      return  ans;
    }
}
// @lc code=end


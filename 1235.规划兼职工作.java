/*
 * @lc app=leetcode.cn id=1235 lang=java
 *
 * [1235] 规划兼职工作
 */

//动态规划
//把工作完成时间排序
//使用 dp[i] 表示前 i 份兼职工作可以获得的最大报酬
//根据第 i−1 份兼职工作是否被选择



// @lc code=start
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;

        int[][] jobs=new int[n][];
        for(int i=0;i<n;i++){
            jobs[i]=new int[]{startTime[i],endTime[i],profit[i]};
        }
        
        Arrays.sort(jobs,(a,b)->{
            return a[1]-b[1];
        });
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int k=search(jobs,i-1,jobs[i-1][0]);
            dp[i]=Math.max(dp[i-1],dp[k]+jobs[i-1][2]);
        }
        return dp[n];
    }
    public int search(int[][] jobs,int right,int target){
        int left=0;
        while(left<right){
            int mid=(right+left)/2;
            if(jobs[mid][1]>target){
                right=mid;
                
            }else{
                left=mid+1;
            }
        }
        return left;
        
    }
}
// @lc code=end


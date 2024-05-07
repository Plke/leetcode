/*
 * @lc app=leetcode.cn id=1463 lang=java
 *
 * [1463] 摘樱桃 II
 */

//dp[x][y1][y2],表示第x行，两个机器人分别处于y1,y2位置时的能取到的最大值
//如果y1==y2，那么两个机器人只能从同一个位置取樱桃，否则只能从两个位置取樱桃
//最后答案从最后一行的所有状态中取最大值

//有点问题，样例没过

// @lc code=start
class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        dp[0][0][cols-1]=grid[0][0]+grid[0][cols-1];

        for(int x=1;x<rows;x++){
            for(int y1=0;y1<cols;y1++){
                for(int y2=0;y2<cols;y2++){
                    //遍历9个状态
                    for(int k1=y1-1;k1<=y1+1;k1++){
                        for(int k2=y2-1;k2<=y2+1;k2++){
                            if(k1<0||k1>=cols||k2<0||k2>=cols){
                                continue;
                            }
                            else{
                                if(y1==y2){
                                    dp[x][y1][y2]=Math.max(dp[x][y1][y2],dp[x-1][k1][k2]+grid[x][y1]);
                                }
                                else{
                                    dp[x][y1][y2]=Math.max(dp[x][y1][y2],dp[x-1][k1][k2]+grid[x][y1]+grid[x][y2]);
                                }
                            }
                        }
                    }
                    // System.out.println("x:"+x+" y1:"+y1+" y2:"+y2+"总数:"+dp[x][y1][y2]);
                }
            }
        }
        int ans=0;
        for(int y1=0;y1<cols;y1++){
            for(int y2=0;y2<cols;y2++){
                ans=Math.max(ans,dp[rows-1][y1][y2]);
            }
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */


// 设置一个对应的时间矩阵
// 同时符合时间以及可以被腐蚀的就可以腐蚀
// 被腐蚀的对应的时间为当前+1


// @lc code=start
class Solution {
    public  int[] x=new int[]{-1,0,1,0};
    public  int[] y=new int[]{0,1,0,-1};
    public  int add=1;
    public int orangesRotting(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int tag=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    tag=1;
                }
            }
        }
        if(tag==0){
            return 0;
        }
        int[][] time=new int[n][m];
        int t=0;
        while(add!=0){
            add=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==2&&time[i][j]==t){
                        for(int k=0;k<4;k++){
                            if(i+x[k]>=0&&i+x[k]<n&&j+y[k]>=0&&j+y[k]<m&&grid[i+x[k]][j+y[k]]==1){
                                grid[i+x[k]][j+y[k]]=2;
                                time[i+x[k]][j+y[k]]=t+1;
                                add++;
                            }
                        }
                    }                  
                }
            }
            t++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return t-1;
    }
}
// @lc code=end

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
/*
 * @lc app=leetcode.cn id=857 lang=java
 *
 * [857] 雇佣 K 名工人的最低成本
 */

贪心

// @lc code=start
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
        //性价比从低到高排序
        PriorityQueue<double[]> list=new PriorityQueue<>((b,a)->{
            return Double.compare(a[0]/a[1],b[0]/b[1]);
        });
        for(int i=0;i<n;i++){
            list.offer(new double[]{(double)wage[i],(double)quality[i]});
        }


        
        for(int i=0;i<n;i++){
            double[] first=list.poll();
            double standard=first[0]/first[1];
            double res=first[0];
            for(int j=i+1;j<n;j++){
                double[] temp=list.poll();
                if(temp[1]*standard<temp[0]){
                    break;
                }
                res+=temp[1]*standard;
            }

        }
        
        return res;
    }
}
// @lc code=end


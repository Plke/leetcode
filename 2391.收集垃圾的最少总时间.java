/*
 * @lc app=leetcode.cn id=2391 lang=java
 *
 * [2391] 收集垃圾的最少总时间
 */

// 简单的模拟题
// 遍历每个字符串的字符
// 使用一个数组维护每辆车的当前位置
// 车没到就加上时间
// 时间复杂度大概为O(nm), n为字符串个数，m为每个字符串长度

// @lc code=start
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans=0;
        int[] car=new int[]{0,0,0};
        for(int i=0;i<garbage.length;i++){
            for(int j=0;j<garbage[i].length();j++){
                ans++
                char c=garbage[i].charAt(j);
                if(c=='M'){
                    if(car[0]!=i){
                        for(int k=car[0];k<i;k++){
                            ans+=travel[k];
                        }
                        car[0]=i;
                    }
                }
                else if(c=='P'){
                    if(car[1]!=i){
                        for(int k=car[1];k<i;k++){
                            ans+=travel[k];
                        }
                        car[1]=i;
                    }
                }
                else if(c=='G'){
                    if(car[2]!=i){
                        for(int k=car[2];k<i;k++){
                            ans+=travel[k];
                        }
                        car[2]=i;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end


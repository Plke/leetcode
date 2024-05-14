/*
 * @lc app=leetcode.cn id=2244 lang=java
 *
 * [2244] 完成所有任务需要的最少轮数
 */

// @lc code=start
class Solution {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tasks){
            // if(map.containsKey(i))
            // {
                map.put(i, map.getOrDefault(i,0) + 1);
            // }
            // else 
            // map.put(i,1);
        }
        int ans=0;
        for(Integer i : map.values()){
            if(i==1) return -1;
            if(i%3==0){
                ans+=(i/3);
            }
            else{
                ans += 1 + i / 3;
            }
        }
        return  ans;
    }
}
// @lc code=end


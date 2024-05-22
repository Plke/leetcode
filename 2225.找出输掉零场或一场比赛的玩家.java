/*
 * @lc app=leetcode.cn id=2225 lang=java
 *
 * [2225] 找出输掉零场或一场比赛的玩家
 */

// 使用hash统计输的次数

// @lc code=start
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> lose=new HashMap<>();
        for(int[] key:matches){
            lose.put(key[0],lose.getOrDefault(key[0],0));
            lose.put(key[1],lose.getOrDefault(key[1],0)+1);
        }
        List<Integer> a1=new ArrayList<>();
        List<Integer> a2=new ArrayList<>();
        lose.forEach((key,value)->{
            if(value==0){
                a1.add(key);
            }
            else if(value==1){
                a2.add(key);
            }
        });
        a1.sort((a,b)->a-b);
        a2.sort((a,b)->a-b);
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(a1);
        ans.add(a2);
        return ans;
    }
}
// @lc code=end


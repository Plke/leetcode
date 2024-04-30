/*
 * @lc app=leetcode.cn id=1146 lang=java
 *
 * [1146] 快照数组
 */

// @lc code=start
class SnapshotArray {
    private int snap_id;
    private int[] x;
    private int length;
    private ArrayList<int[]> photo;

    public SnapshotArray(int length) {
        this.snap_id = 0;
        this.length = length;
        this.x = new int[length + 1];
        photo = new ArrayList<>();
    }


    public void set(int index, int val) {
        x[index] = val;
    }

    public int snap() {
        x[length] = this.snap_id;
        photo.add(x.clone());
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        for(int i=0;i<photo.size();i++)
        {
            if(photo.get(i)[length]==snap_id){
                return photo.get(i)[index];
            }
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end


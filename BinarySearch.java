
class BinarySearch {
    // 返回第一个为目标的值的索引
    public static int binarySearch1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            if(arr[mid] >= target){
              right=mid-1;
            }
            else{
                left=mid+1;
            }
            System.out.println("left:"+left+" right:"+right);
        }

        System.out.println(" left:"+left);
        return  left;          
    }
    // 返回最后一个为目标的值的索引
    public static int binarySearch2(int[] arr, int target) {
      int left = 0;
      int right = arr.length - 1;
      
      while (left < right) {
          int mid = (right + left ) / 2;
          if(arr[mid] <= target){
              left=mid+1;
          }
          else{
              right=mid-1;
          }
          System.out.println("left:"+left+" right:"+right);
      }
      System.out.println(" right:"+right);
      return  right;
    }
    public static void main(String[] args) {
        int[] arr = {1 ,5,6,8,8,8,9,10,11};
        int target = 8;

        int firstIndex = binarySearch1(arr, target);
        System.out.println("第一个为目标的值：" + firstIndex);
        int lastIndex = binarySearch2(arr, target);
        System.out.println("最后一个为目标的值：" + lastIndex);
    }
}
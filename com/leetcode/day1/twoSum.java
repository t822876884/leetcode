package leetcode.day1;

/**
 * 排序数组中两个数字的和
 */
public class twoSum {
    public static int[] twoSum(int[] array, int target){
        int i = 0;
        int j = array.length - 1;
        while (array[i] + array[j] != target) {
            if (array[i] + array[j]>target){
                j--;
            }else {
                i++;
            }
        }
        return new int[]{i,j};
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,6,10};
        int target = 8;
        int[] ints = twoSum(array, target);
        System.out.printf(ints[0]+" "+ints[1]);
    }
}

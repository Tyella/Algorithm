package Algorithm;

public class FindMinII {
    //寻找旋转排序数组中的最小值 II
    public int findMinII(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high])
                high = mid;
            else if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high--;
        }
        return nums[low];
    }
}

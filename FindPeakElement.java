package Algorithm;

public class FindPeakElement {
    //寻找峰值
    //只要两端任意一端比中点大，就意味着一方有峰
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid == low)
                return nums[high] > nums[low] ? high : low;
            if (nums[mid] > nums[mid + 1])
                high = mid;
            else
                low = mid;
        }
        return -1;
    }
}

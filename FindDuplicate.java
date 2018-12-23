package Algorithm;

public class FindDuplicate {
    //寻找重复数
    //首先求出中点mid，然后统计小于等于mid的个数。如果个数大于mid，则在1到mid之间，负责，在mid+1到n之间
    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int counter = 0;
            for (int a : nums) {
                if (a <= mid)
                    counter++;
            }
            if (counter > mid)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}

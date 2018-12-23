package Algorithm;

import java.util.Arrays;

public class SearchRange {
    //在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;

            if (nums[mid] == target) {
                res[0] = findFirst(nums, start, mid, target);
                res[1] = findEnd(nums, mid, end, target);
                return res;
            }
        }
        return res;
    }

    private int findFirst(int[] nums, int start, int end, int target) {
        while (start < end) {
            int temp = start + (end - start) / 2;
            if (nums[temp] < target) {
                start = temp + 1;
            } else if (nums[temp] == target) {
                end = temp;
            }
        }

        return start;
    }

    private int findEnd(int[] nums, int start, int end, int target) {
        while (start < end) {
            //例如一组数为5 5 6 6 6，为了匹配最右边的6，要加上1（end-start+1),
            //否则无法匹配，会陷入死循环，findEnd无法终止
            int temp = start + (end - start + 1) / 2;
            if (nums[temp] > target) {
                end = temp - 1;
            } else if (nums[temp] == target) {
                start = temp;
            }
        }

        return start;
    }
}

package Algorithm;

import java.util.Arrays;

public class TwoSum {
    //两数之和，输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];
        Arrays.fill(res, 0);
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (target < sum)
                right--;
            else
                left++;
        }
        return res;
    }
}

package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {
    //两个数组的交集II
    public int[] intersect(int[] nums1, int[] nums2) {
        int a1 = 0;
        int a2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        while (a1 < nums1.length && a2 < nums2.length) {
            if (nums1[a1] == nums2[a2]) {
                list.add(nums1[a1]);
                a1++;
                a2++;
            } else if (nums1[a1] < nums2[a2])
                a1++;
            else
                a2++;
        }
        int[] res = new int[list.size()];
        int p = 0;
        for (Integer integer : list)
            res[p++] = integer;
        return res;
    }
}

package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    //求两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        Set<Integer> tmp = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++)
            s1.add(nums1[i]);
        for (int j = 0; j < nums2.length; j++)
            s2.add(nums2[j]);
        for (Integer integer : s1) {
            if (s2.contains(integer))
                tmp.add(integer);
        }
        int a = 0;
        int[] res = new int[tmp.size()];
        for (Integer p : tmp)
            res[a++] = p;
        return res;
    }
}

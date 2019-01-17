package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    /*
    leetcode 03
    求无重复字符的最长子串
     */
    /*
    这里我们可以建立一个HashMap，建立每个字符和其最后出现位置之间的映射
    ，然后我们需要定义两个变量res和left，其中res用来记录最长无重复子串的长度，
    left指向该无重复子串左边的起始位置的前一个，由于是前一个，
    所以初始化就是-1，然后我们遍历整个字符串，对于每一个遍历到的字符，如果该字符已经在HashMap中存在了，并且如果其映射值大于left的话，
    那么更新left为当前映射值。然后映射值更新为当前坐标i，这样保证了left始终为当前边界的前一个位置，然后计算窗口长度的时候，
    直接用i-left即可，用来更新结果res，代码如下：
     */
    public int lengthOfLongestSubstring(String s) {
        /**int length = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < length; j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;**/
        int length=s.length();
        int res=0;
        int left=-1;        //指向无重复子串左起的前一个
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++){
            if(map.containsKey(s.charAt(i))){
                i=Math.max(map.get(s.charAt(i)),i);
            }
            res=Math.max(res,i-left);
            map.put(s.charAt(i),i);
        }
        return res;
    }
}

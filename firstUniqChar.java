package String;
import java.util.Map;
import java.util.LinkedHashMap;

public class firstUniqChar {
	public int firstUniqChar(String s) {
		Map<Character,Integer> map=new LinkedHashMap<>();
		char[] str=s.toCharArray();
		for(int i=0;i<str.length;i++) {
			if(!map.containsKey(str[i])) {
				map.put(str[i], i);
			}
			else {
				map.put(str[i], -1);
			}
		}
		for(Map.Entry<Character, Integer> entry:map.entrySet()) {
			if(entry.getValue()!=-1)
				return entry.getValue();
		}
		return -1;
	}
	
}

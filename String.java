
public class String {
	public int lengthOfLongestSubstring(String s) {
		int n=s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
		
	}
	
	public ListNode reverseList(ListNode head) {
            	if(head==null || head.next==null)
    		return head;
    	ListNode pcur=head;
    	ListNode prev=null;
    	while(pcur!=null) {
    		ListNode ptmp=pcur;
    		pcur=pcur.next;
    		ptmp.next=prev;
    		prev=ptmp;
    	}
    	return prev;
    }
	
	public int mySqrt(int x) {
		int low=0;
		int high=x;
		while(low<=high) {
			long mid=(long)(low+high)/2;
			if(mid*mid>x)
				high=(int)mid-1;
			else if(mid*mid<x)
				low=(int)mid+1;
			else
				return (int)mid;
		}
		return high;
}
	
	public int maxArea(int[] height) {
        int max=0,tmp=0;
       int x=0;
       for(int i=0;i<height.length-1;i++)
    	   for(int j=i+1;j<height.length;j++) {
    		   x=(height[i]>height[j])?height[j]:height[i];
    		   tmp=x*(j-i);
    		   max=tmp>max?tmp:max;
    	   }
       return max;
    }

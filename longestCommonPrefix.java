package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class longestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0)
			return "";
		String prefix=strs[0];
		for(int i=1;i<strs.length;i++) {
			while(strs[i].indexOf(prefix)!=0) {
				prefix=prefix.substring(0,prefix.length()-1);
				if(prefix.length()==0)
					return "";
			}
		}
		return prefix;
	}

	public int strStr(String haystack, String needle) {
		if(needle.length()==0)
			return 0;
		for(int i=0;i<haystack.length()-needle.length()+1;i++) {
			if(haystack.substring(i,needle.length()+i).equals(needle))
					return i;
		}
		return -1;
    }
	
    public boolean isPalindrome(String s) {
    	if(s.length()<=1)
    		return true;
    	char[] c=s.toLowerCase().toCharArray();
    	char[] tc=new char[c.length];
    	int a=0;
    	for(int i=0;i<c.length;i++) {
    		if((c[i]>64 && c[i]<91)||(c[i]>96 && c[i]<123)||(c[i]>47 && c[i]<58)) {
    			tc[a]=c[i];
    		a++;
    		}
    	}
    	for(int i=0;i<a/2;i++) {
    		if(tc[i]!=tc[a-i-1])
    			return false;
    	}
    	return true;
    }
    
    public String reverseWrods(String s) {
    	/*
    	 * 利用split()对字符串进行分割，分成字符数组
    	 */
    	String[] arr=s.trim().split(" ");
    	StringBuilder str=new StringBuilder();
    	for(int i=arr.length-1;i>0;i--) {
    		if(arr[i].length()>0)
    			str.append(arr[i]).append(" ");
    	}
    	/*
    	 * 最后要加上arr[0],并且后面不加空格
    	 */
    	str.append(arr[0]);
    	return str.toString();
    }
    
    public int removeDuplicates(int[] nums) {
    	int index=0;
    	for(int i=0;i<nums.length;i++) {
    		if((i!=0)&& nums[i]==nums[i-1])
    			continue;
    		nums[index++]=nums[i];
    	}
    	return index;
    }
    
    public int maxSubArray(int[] nums) {
    	int sum=0;
    	int answer=nums[0];
    	for(int i=0;i<nums.length;i++) {
    		sum+=nums[i];
    		if(sum>answer)
    			answer=sum;
    		if(sum<0)
    			sum=0;
    	}
    	return answer;
    }
    
    
    public class ListNode{
    	int val;
    	ListNode next;
    	ListNode(int x){
    		val=x;
    	}
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
    
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	   if(l1==null)
		   return l2;
	   if(l2==null)
		   return l1;
	   ListNode head=null;
	   if(l1.val<l2.val) {
		   head=new ListNode(l1.val);
		   head.next=mergeTwoLists(l1.next,l2);
	   }
	   else {
		   head=new ListNode(l2.val);
		   head.next=mergeTwoLists(l1,l2.next);
	   }
	   return head;
    }
   public ListNode mergeTwoList(ListNode l1,ListNode l2) {
	   ListNode head=new ListNode(0);
	   ListNode tmp=head;
	   while(l1!=null && l2!=null) {
		   if(l1.val<l2.val) {
			   tmp.next=l1;
			   l1=l1.next;
		   }
		   else {
			   tmp.next=l2;
			   l2=l2.next;
		   }
		   tmp=tmp.next;
	   }
	   if(l1==null) {
		   tmp.next=l2;
	   }
	   if(l2==null) {
		   tmp.next=l1;
	   }
	   return head.next;
   }
   
   public void deleteNode(ListNode node) {
	   node.val=node.next.val;
	   node.next=node.next.next;
   }
   
   public int reverse(int x) {
	   long res=0;
	   while(x!=0) {
		   res=res*10+x%10;
		   x/=10;
	   }
	   return (res>Integer.MAX_VALUE || res<Integer.MIN_VALUE)?0:(int)res;
   }
   
   public boolean isPalindrome(int x) {
	   char[] str=String.valueOf(x).toCharArray();
	   for(int i=0;i<str.length/2;i++) {
		   if(str[i]!=str[str.length-i-1])
			   return false;
	   }
	   return true;
   }
   
   public int singleNumber(int[] nums) {
	   Arrays.sort(nums);
	   int m=0,n=0;
	   int i;
	   for(i=0;i<nums.length-2;i+=2) {
		   m=nums[i];
		   n=nums[i+1];
		   if(m!=n)
			   return m;
	   }
       return nums[i];
   }
   
   public boolean isPowerOfTwo(int n) {
	   if(n==1)
		   return true;
	   while(n>1) {
		   if(n%2==1) return true;
		   n/=2;
		   if(n==1) return true;
	   }
	   return false;
   }
   
   public int[] twoSum(int[] nums, int target) {
       int m=0,n=0;
       for(int i=0;i<nums.length;i++) 
    	   for(int j=1;j<nums.length;j++) {
    		   if(i==j) continue;
    		   if(nums[i]+nums[j]==target) {
    			   m=i;
    			   n=j;
    		   }
    	   }
       return new int[] {m,n};
   }
   
   public int[] twoSum1(int[] nums, int target) {
	      Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement) && map.get(complement) != i){
					return new int[]{map.get(complement), i};
				}
				map.put(nums[i], i);
			}
			return null;
	    }
   
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	   int p=0,left=0,right=0;
	   int ll=nums1.length;
	   int lr=nums2.length;
	   int[] sum=new int[ll+lr];
	   while(left<ll && right<lr) {
		   if(nums1[left]<nums2[right])
			   sum[p++]=nums1[left++];
		   else
			   sum[p++]=nums2[right++];
	   }
	   while(left<ll) {
		   sum[p++]=nums1[left++];
	   }
	   while(right<lr) {
		   sum[p++]=nums2[right++];
	   }
	   if((ll+lr)%2!=0) {
		   return sum[(ll+lr)/2];
	   }
	   else {
		   return (sum[(ll+lr)/2]+sum[(ll+lr)/2-1])/2;
	   }
   }
   
   public String longestPalindrome(String s) {
       int maxPalinLength=0;
       String longestPalindrome=null;
       int length=s.length();
       if(length==1){
          longestPalindrome=s;
          return longestPalindrome;
       }
       for(int i=0;i<s.length();i++){
           for(int j=i+1;j<s.length()+1;j++){
               int len=j-i;
               String curr=s.substring(i,j);
               if(isPalindrome(curr)){
                   if(len>maxPalinLength){
                       longestPalindrome=curr;
                       maxPalinLength=len;
                   }
               }
           }
       }
       return longestPalindrome;
   }
   public static boolean isPalindrome1(String s){
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)!=s.charAt(s.length()-i-1)){
               return false;
           }
       }
       return true;
   }

   public int myAtoi(String str) {
	   char[] nums=new char[str.length()];
	   char[] res=new char[str.length()];
	   int p=0;
	   nums=str.toCharArray();
	   for(int i=0;i<nums.length;i++) {
		   if((nums[i]=='-') || (nums[i]>47 && nums[i]<58))
			   res[p++]=nums[i];
		   else
			   return 0;
	   }
	   return Integer.parseInt(res.toString());
	   
   }
   
   public String reverseString(String s) {
	   StringBuilder str=new StringBuilder(s);
	   String ret=new String();
	   str=str.reverse();
	   ret+=str;
	   return ret;
   }
   
   public boolean containsDuplicate(int[] nums) {
       Arrays.sort(nums);
       for(int i=0;i<nums.length;i++) {
    	   if(nums[i]==nums[i+1])
    		   return false;
       }
       return true;
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
   
   public String multiply(String num1, String num2) {
       int ret=Integer.parseInt(num1)*Integer.parseInt(num2);
       return String.valueOf(ret);
   }
   

   public int findKthLargest(int[] nums, int k) {
	   PriorityQueue pq=new PriorityQueue(nums.length);
	   for(int i=0;i<nums.length;i++)
		   pq.add(nums[i]);
	   for(int j=0;j<nums.length-k;j++)
		   pq.poll();
	   return nums[0];
   }

   public  String onReversing(String s){
       if(null == s || s.length() < 1){
           return null;
       }
       
       char strArray[] = s.toCharArray();
       int len = strArray.length;
       int j = 0;
       for(int i= 1 ; i < len ; i++ ){
           
           if(strArray[i] == ' '){
               swap(strArray,j, i-1);
               j = i+1;
           }else if(i== len-1){//当判断到最后位置 且非空时
               swap(strArray,j, i);
           }
       
       }
       return new String(strArray);
   }
   
   private void swap(char[] strArray, int j, int i) {
       // TODO Auto-generated method stub
       while(j < i){
           char temp = strArray[j];
           strArray[j] = strArray[i];
           strArray[i] = temp;
           j++;
           i--;
       }
       } 


    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int index = -1;
        int end = 0;
        while (true) {
            start = index + 1;
            index = s.indexOf(' ', start);
            end = index - 1;
            reverse(arr, start, end);
            if (index == -1) {
                // reverse last word without '\0' character 
                reverse(arr, start, arr.length - 1);
                break;
            }
        }
        return new String(arr);
    }
    void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }

    class Solution {
        public ListNode sortList(ListNode head) {
        	if(head==null || head.next==null)
        		return head;
        	ListNode fast=head.next;
        	ListNode slow=head;
        	while(fast.next!=null) {
        		slow=slow.next;
        		fast=fast.next;
        		if(fast.next!=null)
        			fast=fast.next;
        	}
        	ListNode ptr=slow.next;
        	slow.next=null;     //防止堆栈溢出
        	ListNode tmp1=sortList(head);
        	ListNode tmp2=sortList(ptr);
        	return merge(tmp1,tmp2);
        }
         public ListNode merge(ListNode start1,  ListNode start2) {
        	 ListNode header=new ListNode(-1);
        	 ListNode ptr=header;
        	 while(start1!=null && start2!=null) {
        		 if(start1.val<=start2.val) {
        			 ptr.next=start1;
        			 ptr=start1;
        			 start1=start1.next;
        		 }
        		 else {
        			 ptr.next=start2;
        			 ptr=start2;
        			 start2=start2.next;
        		 }
        	 }
        	 while(start1!=null) {
        		 ptr.next=start1;
        		 ptr=start1;
        		 start1=start1.next;
        	 }
        	 while(start2!=null) {
        		 ptr.next=start2;
        		 ptr=start2;
        		 start2=start2.next;
        	 }
        	 return header.next;
         }
    }

}

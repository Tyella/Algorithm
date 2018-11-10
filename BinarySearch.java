import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearch {
	//寻找峰值
    //只要两端任意一端比中点大，就意味着一方有峰
	public int findPeakElement(int[] nums) {
		if(nums.length==1)
			return 0;
		int low=0;
		int high=nums.length-1;
		while(low<high) {
			int mid=low+(high-low)/2;
			if(mid==low)
				return nums[high]>nums[low]?high:low;
			if(nums[mid]>nums[mid+1])
				high=mid;
			else
				low=mid;
		}
		return -1;
	}
	
	//寻找旋转排序数组中的最小值
	public int findMin(int[] nums) {
		int low=0,high=nums.length-1;
		while(low<high) {
			int mid=low+(high-low)/2;
			if(nums[mid]>nums[high])
				low=mid+1;
			else
				high=mid;
		}
		return nums[low];
	}
	
	//寻找旋转排序数组中的最小值 II
	public int findMinII(int[] nums) {
		int low=0,high=nums.length-1;
		while(low<high) {
			int mid=low+(high-low)/2;
			if(nums[mid]<nums[high])
				high=mid;
			else if(nums[mid]>nums[high])
				low=mid+1;
			else
				high--;
		}
		return nums[low];
	}
	
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
    
    //Pow(x,n)
    public double myPow(double x,int n) {
    	if(x==0) return 0.0;
    	if(n==0) return 1.0;
    	double ans=1.0;
    	if(n>0) {
    		ans=myPowRecursive(x,n);
    		return ans;
    	}
    	else if(n<0) {
    		//int的取值范围为：-2147483648到2147483647,当-2147483648取反时会导致超出int的取值范围
    		ans=x*myPowRecursive(x,-(n+1));    //防止超出int的范围
    		return 1.0/ans;
    	}
    	return 0;
    }
    private double myPowRecursive(double x,int n) {
    	if(n==0) return 1.0;
    	if(n==1) return x;
    	double res=1.0;
    	res=myPowRecursive(x,n/2);
    	if(n%2==1) 
    		return x*res*res;
    	else
    		return res*res;
    }
    
    
    //有效的完全平方数
    public boolean isPerfectSquare(int num) {
    	if(num==1 || num==0)
    		return true;
    	int low=1;
    	int high=num;
    	while(low+1<high) {
    		int mid=low+(high-low)/2;
    		if(mid*mid==num)
    			return true;
    		//if(mid*mid>num)在有些情况下通不过
    		if(mid>num/mid)
    			high=mid;
    		else
    			low=mid;
    	}
    	return false;
    }
    
    //寻找比目标字母大的最小字母
    public char nextGreatestLetter(char[] letters,char target) {
    	int n=letters.length;
    	int low=0,high=n;
    	while(low<high) {
    		int mid=low+(high-low)/2;
    		if(letters[mid]<=target)
    			low=mid+1;
    		else 
    			high=mid; //mid-1通不过
    	}
    	return low<n?letters[low]:letters[0];
    }
    
    //寻找重复数
    //首先求出中点mid，然后统计小于等于mid的个数。如果个数大于mid，则在1到mid之间，负责，在mid+1到n之间
    public int findDuplicate(int[] nums) {
    	int start=1;
    	int end=nums.length-1;
    	while(start<end) {
    		int mid=start+(end-start)/2;
    		int counter=0;
    		for(int a:nums) {
    			if(a<=mid)
    				counter++;
    		}
    		if(counter>mid)
    			end=mid;
    		else
    			start=mid+1;
    	}
    	return start;
    }
    
    //两数之和，输入有序数组
    public int[] twoSum(int[] numbers,int target) {
    	int left=0;
    	int right=numbers.length-1;
    	int[] res=new int[2];
    	Arrays.fill(res,0);
    	while(left<right) {
    		int sum=numbers[left]+numbers[right];
    		if(target==sum) {
    			res[0]=left+1;
    			res[1]=right+1;
    			return res;
    		}
    		else if(target<sum)
    			right--;
    		else
    			left++;
    	}
    	return res;
    }
    
    //求两个数组的交集
    public int[] intersection(int[] nums1,int[] nums2) {
    	Set<Integer> s1=new HashSet<Integer>();
    	Set<Integer> s2=new HashSet<Integer>();
    	Set<Integer> tmp=new HashSet<Integer>();
    	for(int i=0;i<nums1.length;i++)
    		s1.add(nums1[i]);
    	for(int j=0;j<nums2.length;j++)
    		s2.add(nums2[j]);
    	for(Integer integer:s1) {
    		if(s2.contains(integer))
    			tmp.add(integer);
    	}
    	int a=0;
    	int[] res=new int[tmp.size()];
    	for(Integer p:tmp)
    		res[a++]=p;
    	return res;
    }
    
    //两个数组的交集II
    public int[] intersect(int[] nums1,int[] nums2) {
    	int a1=0;
    	int a2=0;
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	List<Integer> list=new ArrayList<Integer>();
    	while(a1<nums1.length && a2<nums2.length) {
    		if(nums1[a1]==nums2[a2]) {
    			list.add(nums1[a1]);
    			a1++;
    			a2++;
    		}
    		else if(nums1[a1]<nums2[a2])
    			a1++;
    		else
    			a2++;
    	}
    	int[] res=new int[list.size()];
    	int p=0;
    	for(Integer integer:list)
    		res[p++]=integer;
    	return res;
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
	   return (sum[(ll+lr)/2]+sum[(ll+lr)/2-1])/2.0;
}
}
    
    
}


public class BinarySearch {
	
	//寻找峰值
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
			if(nums.length==1)
				return nums[0];
			int low=0;
			int high=nums.length-1;
			while(low<high) {
				int mid=low+(high-low)/2;
				if(nums[low]<nums[mid] && nums[mid]<nums[high])
					return nums[low];
				if(low==mid && (high-low)==1)
					return  nums[high]>nums[low]?nums[low]:nums[high];
				if(nums[low]<nums[mid])
					low=mid;
				else
					high=mid;
			}
			return -1;
		}
}

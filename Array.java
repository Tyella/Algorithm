
public class Array {
	public int pivotIndex(int[] nums) {
		if(nums==null || nums.length==1 || nums.length==2)
			return -1;
		for(int i=1;i<nums.length-2;i++) {
			int left=leftNum(0,i-1,nums);
			int right=rightNum(i+1,nums.length-1,nums);
			if(left==right)
				return i;
		}
		return -1;
	}
	public int leftNum(int left,int right,int[] nums) {
		int sum=0;
		for(int i=left;i<=right;i++)
			sum+=nums[i];
		return sum;
	}
	public int rightNum(int left,int right,int[] nums) {
		int sum=0;
		for(int i=left;i<=right;i++)
			sum+=nums[i];
		return sum;
	}
}

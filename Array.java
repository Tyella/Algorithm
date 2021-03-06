import java.util.*;

public class Array {
	//求数组的中间索引
	public int pivotIndex(int[] nums) {
		int sum=0,t=0;
		if(nums.length==0) return -1;
		if(nums.length==1) return 0;
		for(int i=0;i<nums.length;i++) sum+=nums[i];
		for(int i=0;i<nums.length;i++) {
			sum-=nums[i];
			if(sum==t)
				return i;
			t+=nums[i];
		}
		return -1;
	}
	
	//矩阵对角线便历
	public int[] findDragonalOrder(int[][] matrix) {
		if(matrix.length==0)
			return new int[0];
		int m=matrix.length;         //矩阵有m行
		int n=matrix[0].length;      //矩阵有n列
		int[] result=new int[m*n];
		int r=0,c=0;                 //row,column
		for(int i=0;i<result.length;i++) {
			result[i]=matrix[r][c];
			if((r+c)%2==0) {          //索引之和为偶数
				if(c==n-1)             //如果是最后一列，向下
					r++;
				else if(r==0)          //如果是第一列，向右
					c++;
				else {                 //其他情况，言对角线向右上
					r--;
					c++;
				}
			}else {                   //索引之和为奇数
				if(r==m-1)             //如果是最后一行，向右
					c++;
				else if(c==0)          //如果是第一列，向下
					r++;
				else {                 //其他情况，沿对角线向左下找
					r++;
					c--;
				}
			}
		}
		return result;
	}
	
	//加一
	public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--) {
			if(digits[i]<9) {
				++digits[i];
				return digits;
			}
			digits[i]=0;
		}
		int[] res=new int[digits.length+1];
		res[0]=1;     //数组默认值为零
		return res;
    }
	
	//至少是其他数字两倍的最大数
	public int dominantIndex(int[] nums) {
        int max=-1,secmax=-1,index=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max) {
				secmax=max;
				max=nums[i];
				index=i;
			}
			else if(nums[i]>secmax) {
				secmax=nums[i];
			}
		}
		return max>=2*secmax?index:-1;
    }
	
	//螺旋矩阵
	public List<Integer> spiralOrder(int[][] matrix){
		if(matrix.length==0)
			return null;
		List<Integer> list=new LinkedList<Integer>();
		int m=matrix.length;                   //矩阵有m行
		int n=matrix[0].length;                //矩阵有n列
		int total=m*n;                         //矩阵中的总元素
		int sum=1;                             //计数器
		int rowBegin=0;
		int rowEnd=m-1;
		int columnBegin=0;
		int columnEnd=n-1;
		while(sum<total) {
			for(int i=columnBegin;i<=columnEnd;i++,sum++)
				list.add(matrix[rowBegin][i]);
			rowBegin++;
			
			for(int i=rowBegin;i<=rowEnd;i++,sum++)
				list.add(matrix[i][columnEnd]);
			columnEnd--;
			
			for(int i=columnEnd;i>=columnBegin;i--,sum++)
				list.add(matrix[rowEnd][i]);
			rowEnd--;
			
			for(int i=rowEnd;i>=rowBegin;i--,sum++)
				list.add(matrix[i][columnBegin]);
			columnBegin++;
		}
		return list;
	}
	
	//杨辉三角
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(numRows<=0)
			return res;
		for(int i=0;i<numRows;i++) {
			List<Integer> list=new LinkedList<>();
			for(int j=0;j<=i;j++) {
				if(j==0 || j==i)
					list.add(1);
				else                   //trangle[i][j]=trangle[i-1][j]+trangle[i-1][j-1];
					list.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));    
			}
			res.add(list);
		}
		return res;
	}
	
	//leetcode 14
	//最长公共前缀
	public String longestCommonPrefix(String[] strs) {
		if(strs==null)
			return "";
		String prefix=strs[0];                              //假设数组中的第一个字符串为最长公共前缀
		for(int i=1;i<strs.length;i++) {
			while(strs[i].indexOf(prefix)!=0) {               //前缀不匹配，继续循环
				prefix=prefix.substring(0, prefix.length()-1);
				if(prefix.length()==0)
					return "";
			}
		}
		return prefix;
	}
	
	//数组拆分I
	public int arrayPairSum(int[] nums) {
		if(nums.length==1)
			return nums[0];
		Arrays.sort(nums);
		int sum=0;
			for(int i=0;i<nums.length;i+=2)
				sum+=nums[i];
		return sum;
	}
	
	//最大连续1的个数
	public int findMaxConsecutiveOnes(int[] nums) {
		int max=0,number=0;
		for(int i:nums) {
			if(i==1)
				number++;
			else
				number=0;
			max=Math.max(max, number);
		}
		return max;
	}

	//求三数之和
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> res=new LinkedList<>();
		if(nums==null ||nums.length<=2)
			return res;
		Arrays.sort(nums);
		//先找一个负数target，然后找两个正数之和等于0-target
		//对排序数组用双指针法，从前从后开始遍历，要求满足条件i<j
		for(int k=0;k<nums.length-2;k++){
			if(nums[k]>0)
				break;
			if(k>0 && nums[k]==nums[k-1])
				continue;
			int target=0-nums[k];
			//双指针，i和j分别表示前后指针
			int i=k+1,j=nums.length-1;
			while (i < j) {
				if(target==nums[i]+nums[j]){
					res.add(Arrays.asList(nums[k],nums[i],nums[j]));
					while(i<j && nums[i]==nums[i+1])
						++i;
					while(i<j && nums[j]==nums[j-1])
						--j;
					++i;--j;
				}
				else if(target<nums[i]+nums[j]){
					--j;
				}
				else
					++i;
			}
		}
		return res;
	}

	class Interval {
		private int start;
		private int end;

		public Interval() {
			start = 0;
			end = 0;
		}

		public Interval(int i, int j) {
			start = i;
			end = j;
		}
	}

	//合并区间
	/*
	首先对List进行根据start进行排序
	如果如果第一个数组尾小于第二个数组头，则添加；
	否则，合并两个数组
	 */
	public List<Interval> merge(List<Interval> intervals){
		if(intervals==null || intervals.size()<=1)
			return intervals;
		List<Interval> result=new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		Interval prev=null;
		for(Interval item:intervals){
			if(prev==null || prev.end<item.start){
				result.add(item);
				prev=item;
			}
			else if(prev.end<item.end){
				prev.end=item.end;
			}
		}
		return result;
	}

	//最长连续递增序列
	public int findLengthOfLCIS(int[] nums){
		if(nums.length==0)
			return 0;
		int count=1;
		int max=0;
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]<nums[i+1]){
				count++;
			}
			else{
				max=Math.max(max,count);
				count=1;
			}
		}
		max=Math.max(max,count);
		return max;
	}

	//最长连续序列
	/*
	将数组中所有元素存储到set中，然后选一个元素开始左右遍历。
	如果左右两边的元素都在set中，则--prev,++next;
	next-prev-1就是最长连续序列
	 */
	public int longestConsecutive(int[] nums){
		int res=0;
		Set<Integer> set=new HashSet<>();
		for(int num:nums)
			set.add(num);
		for(int num:nums){
			if(set.remove(num)){
				int prev=num-1;
				int next=num+1;
				while(set.remove(prev))
					--prev;
				while(set.remove(next))
					++next;
				res=Math.max(res,next-prev-1);
			}
		}
		return res;
	}









}

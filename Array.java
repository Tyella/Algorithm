import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

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
}

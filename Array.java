
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
}

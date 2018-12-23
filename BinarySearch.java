package Algorithm;

//二叉查找数及其变种
public class BinarySearch {
	
	//1.查找第一个值等于给定值的元素
	public int binarySearch1(int[] a,int n,int value){
		int low=0;
		int high=n-1;
		while(low<=high){
			int mid=low+((high-low)>>1);
			if(a[mid]<value){
				low=mid+1;
			}else if(a[mid]>value){
				high=mid-1;
			}else{
				if(mid==0 || a[mid-1]!=value)    //如果mid==0,那它已经是数组的第一个元素了,一定是我们要找的
					return mid;                  //如果mid不等于0,a[mid-1]不等于value,那a[mid]就是我们要找的
				else
					high=mid-1;
			}
		}
		return -1;
	}

	//2.查找最后一个值等于给定值的元素
	public int binarySearch2(int[] a,int n,int value){
		int low=0;
		int high=n-1;
		while(low<=high){
			int mid=low+((high-low)>>1);
			if(a[mid]<value){
				low=mid+1;
			}else if(a[mid]>value){
				high=mid-1;
			}else{
				if(mid==n-1 || a[mid+1]!=value)
					return mid;
				else
					low=mid+1;
			}
		}
		return -1;
	}

	//3.查找第一个大于等于给定值的元素
	public int binarySearch3(int[] a,int n,int value){
		int low=0;
		int high=n-1;
		while(low<=high){
			int mid=low+((high-low)>>1);
			if(a[mid]>=value){
				if(mid==0 || a[mid-1]<value)
					return mid;
				else
					high=mid-1;
			}else{
				low=mid+1;
			}
		}
		return -1;
	}

	//4.查找最后一个小于等于给定值的元素
	public int binarySearch4(int[] a,int n,int value){
		int low=0;
		int high=n-1;
		while(low<=high){
			int mid=low+((high-low)>>1);
			if(a[mid]<=value){
				if(mid==n-1 || a[mid+1]>value)
					return mid;
				else
					low=mid+1;
			}else{
				high=mid-1;
			}
		}
		return -1;
	}

}

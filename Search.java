package Algorithm;

public class Search {
    public int search(int[] nums,int target){
        if(nums.length==0)
            return -1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid])
                return mid;
            if(nums[mid]>=nums[low]){
                if(target>=nums[low] && target<nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }else{
                if(target>nums[mid] && target<=nums[high])
                    low=mid+1;
                else
                    high=mid==0?0:mid-1;
            }
        }
        return -1;
    }
}

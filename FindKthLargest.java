package Algorithm;

import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums,int k){
        PriorityQueue pq=new PriorityQueue(nums.length);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int j=0;j<nums.length-k;j++){
            pq.poll();
        }
        return (int)pq.peek();
    }
}

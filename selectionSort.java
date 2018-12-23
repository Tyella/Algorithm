package Algorithm;

//选择排序
//把数组分为已排序和未排序区间，每次从未排序区间中取出最小值，放到已排序区间末尾
public class selectionSort {
    public void selectionSort(int[] a,int n){
        if(n<=1)
            return;
        for(int i=0;i<n-1;++i){
            int minIndex=i;
            for(int j=i+1;j<n-1;++j){
                if(a[j]<a[minIndex])
                    minIndex=j;
            }
            //交换
            int temp=a[i];
            a[i]=a[minIndex];
            a[minIndex]=temp;
        }
    }
}

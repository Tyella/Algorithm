package Algorithm;


public class insertionSort {
    /*
    插入排序
    把要排序的数组分成两个区间，已排序区间和未排序区间
    从未排序区间中取出元素插入到已i排序区间的合理位置
     */
    public void insertionSort(int[] a,int n){
        if(n<=1)
            return;
        for(int i=1;i<n;i++){
            int value=a[i];    //未排序元素区间
            int j=i-1;         //已排序元素区间
            //查找要插入的位置并移动数据
            for(;j>=0;--j){
                if(a[j]>value){
                    a[j+1]=a[j];
                }
                else{
                    break;
                }
            }
            a[j+1]=value;    //--j,边界条件j为-1时才停
        }
    }
}

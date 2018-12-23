package Algorithm;

//冒泡排序
public class bubbleSort {
    public void bubbleSort(int[] a,int n){
        if(n<=1)
            return ;
        for(int i=0;i<n;++i){//有n个元素一共要进行n趟
            //通过交换相邻的两个元素，使其处于正确的排序位置
            for(int j=0;j<n-i-1;++j){    //剩下的没有排序的元素个数
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

}

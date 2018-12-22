package Algorithm;

//冒泡排序
public class bubbleSort {
    public void bubbleSort(int[] a,int n){
        if(n<=1)
            return ;
        for(int i=0;i<n;++i){
            for(int j=0;j<n-i-1;++j){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

}

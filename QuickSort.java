import java.util.Arrays;

public class QuickSort {
    private final int[] array; //array用来存储要排序的数组
    public QuickSort(int[] a){
        array=a;
    }
    public void quick_sort(){
        int low=0;
        int high=array.length-1;
        Quick(array,low,high);
    }

    private void Quick(int[] array,int low,int high){
       if(low<high){
           int p = Partition(array,low,high);
           Quick(array,low,p-1);
           Quick(array,p+1,high);
       }
    }
    private int Partition(int[] array, int low, int high) {
        int temp = array[low];
        int l = low + 1; // 修正这里的初始值
        int h = high;
        while (true) {
            while (l <= h && array[l] < temp) {
                l++;
            }
            while (l <= h && array[h] >= temp) {
                h--;
            }
            if (l > h)
                break;
            exchange(array, l, h);
        }
        exchange(array, low, h);
        return h;
    }


    private void exchange(int[] array,int l,int h){
        int temp = array[l];
        array[l]=array[h];
        array[h]=temp;
    }

    public static void main(String[] args) {
        int[] a={22224,7,9,223,2,5,44,3,3,22,4,4,5,5,6,6,4,3,7,8,67,6,4,7,8};
        QuickSort b = new QuickSort(a);
        b.quick_sort();
        System.out.println(Arrays.toString(a));
    }
}


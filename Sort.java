public class Sort {
    public static void inSort(int[] array){
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int i1 = i; i1 > 0; i1--) {
               if(array[i1]<array[i1-1]){
                   int temp=array[i1-1];
                   array[i1-1]=array[i1];
                   array[i1]=temp;
               }
            }
        }
    }

    public static void MergeSortL(int[] array,int low,int high,int[][] Link,int p){

    }

    public static void main(String[] args) {
        int[] a = {34,66,4,34,889,2,32,3,243,54,5,4,5,65,7,68,7};
        inSort(a);
        for (int i : a) {
           System.out.print(i+" ");
        }
    }
}

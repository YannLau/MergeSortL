import java.util.Arrays;

public class MergeSortL {
    private int[] array;
    public int[] link;
    public int p =-1;
    public MergeSortL(int[] a){
        array=a;
        link =new int[a.length];
        Arrays.fill(link,-1);
    }

    public void merge_sort(){
        int low = 0;
        int high = array.length-1;
        p = do_MergeSort(array,link,low,high);
    }
    public static int do_MergeSort(int[] array,int[] link,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            int q = do_MergeSort(array,link,low,mid);
            int r = do_MergeSort(array,link,mid+1,high);
            return Merge(array,link,q,r);
        }else {
            return low;
        }
    }
    public static int Merge(int[] array,int[] link,int q,int r){
        int p = -1;
        if(array[q]>array[r]){
            p=r;
        }else{
            p=q;
        }
        while(q!=-1 && r!=-1){
            if(array[q]>array[r]){
                int temp = link[r];
                int former_temp = r;
                while(temp!=-1 && array[temp]<=array[q]){
                    former_temp=temp;
                    temp=link[temp];
                }
                link[former_temp]=q;
                r=temp;
            }else{
                int temp = link[q];
                int former_temp=q;
                while( temp!=-1 && array[temp]<=array[r]){
                    former_temp = temp;
                    temp=link[temp];
                }
                link[former_temp]=r;
                q=temp;
            }
        }
        return p;
    }

    public void print_result(){
        if(p==-1){
            this.merge_sort();
        }
        int temp=p;
        while(temp!=-1){
            System.out.print(array[temp]+" ");
            temp=link[temp];
        }
    }

    public static void main(String[] args) {
        int[] array={4,7,3,9,2,1,8,12,31,23,23,4,3,43,4,3,4,3,2,4,34,3,5,4,5,465,5,7,5,7,5763,344};
        MergeSortL a=new MergeSortL(array);
        a.merge_sort();
        System.out.println("p的结果为: "+a.p);
        a.print_result();
        System.out.println();
        for (int i = 0; i < a.link.length; i++) {
            System.out.println(a.link[i]);
        }
//        System.out.println("以下为测试merge");
//        int[] test = {4,7,3,9,2,1,8};
//        int[] link = {1,3,0,-1,6,4,-1};
//        Merge(test,link,2,5);
//        System.out.println(Arrays.toString(link));
    }

}

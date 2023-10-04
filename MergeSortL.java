import java.util.Arrays;

public class MergeSortL {
    private final int[] array; //array用来存储要排序的数组
    public final int[] link; //link是一个数组实现的链表，link[n] 最终存储的是array[n]下一个元素的下标。
    private int p =-1; //p存储的是link的头节点的位置。排序后，array[p]代表整个array中最小的元素。link[p]是array中第二小的元素下标
    public MergeSortL(int[] a){  //构造函数，初始化得到排序需要的数据
        array=a;
        link =new int[a.length];
        Arrays.fill(link,-1); //初始时，link内容都填充为-1. 排序完成后link[n]=-1,表示array[n]为最大的元素
    }

    public void merge_sort(){  //封装函数，用来对对象进行调用排序
        int low = 0;
        int high = array.length-1;
        p = do_MergeSort(array,link,low,high);
    }
    private static int do_MergeSort(int[] array,int[] link,int low,int high){  //归并排序的主体
        if(high-low+1>=16){  //子问题足够大才进行递归调用，减少不必要的划分、合并。这里针对讲义进行设置为16，没有进行通用化处理。
            int mid = (low+high)/2;
            int q = do_MergeSort(array,link,low,mid); //q为划分部分的link头节点位置
            int r = do_MergeSort(array,link,mid+1,high); // r同理
            return Merge(array,link,q,r); //已知两个链表的头，对其进行归并，并返回新的头节点位置。
        }else {  //子问题小于16个元素，直接插入排序。
            return InsortL(array,link,low,high); //这里直接对array数组进行操作，因此array数组的low-high部分为有序的
                                                    // InsortL返回值为link头节点位置
        }
    }
    private static int Merge(int[] array,int[] link,int q,int r){
        int p = -1;
        if(array[q]>array[r]){
            p=r;
        }else{
            p=q;
        }
        while(q!=-1 && r!=-1){
            if(array[q]>array[r]){
                int temp1 = link[r];
                int former_temp = r;
                while(temp1!=-1 && array[temp1]<=array[q]){ //循环找到第一个比array[q]大的元素，temp!=-1写前面，防止下标溢出
                    former_temp=temp1;
                    temp1=link[temp1];
                }
                link[former_temp]=q;  //找到后，链接在一起
                r=temp1; //将指针r更新
            }else{
                int temp2 = link[q];
                int former_temp=q;
                while( temp2!=-1 && array[temp2]<=array[r]){
                    former_temp = temp2;
                    temp2=link[temp2];
                }
                link[former_temp]=r;
                q=temp2;
            }
        }
        return p;
    }

    public void print_result(){
        if(p==-1){  //p==-1说明没有进行排序操作
            this.merge_sort();
        }
        int temp=p;
        while(temp!=-1){
            System.out.print(array[temp]+" ");
            temp=link[temp];
        }
        System.out.println();
    }

    private static int InsortL(int[] array,int[] link,int low,int high){
//        int len = high-low+1;
        for (int i = low+1; i <=high ; i++) { //经典插入排序
            for (int i1 = i; i1 > low; i1--) {
               if(array[i1]<array[i1-1]){
                   int temp = array[i1-1];
                   array[i1-1]=array[i1];
                   array[i1]=temp;
               }
            }
        }
        for(int j=low;j<high;j++){  //link[high]=-1，因此不用操作
            link[j]=j+1;
        }
        return low; //返回头节点位置
    }

    public static void main(String[] args) {
        int[] array={4,7,3,9,2,1,8,12,31,23,23,4,3,43,4,3,4,3,2,4,34,3,5,4,5,465,5,7,5,7,5763,344};
        MergeSortL a=new MergeSortL(array);
        //a.merge_sort();
        //System.out.println("p的结果为: "+a.p);
        a.print_result(); //直接打印会自动判断是否排序，从而进行自动排序
        //System.out.println(Arrays.toString(array));
//        for (int i = 0; i < a.link.length; i++) {
//            System.out.print(a.link[i]+" ");
//        }


//        System.out.println("以下为测试merge");
//        int[] test = {4,7,3,9,2,1,8};
//        int[] link = {1,3,0,-1,6,4,-1};
//        Merge(test,link,2,5);
//        System.out.println(Arrays.toString(link));

        //测试InsortL
//        int[] arr = {2,4,52,2,55,6,23,13,45,35};
//        int[] link={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
//        int test = InsortL(arr,link,4,9);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(link));
//        System.out.println("p值为："+test);
    }

}

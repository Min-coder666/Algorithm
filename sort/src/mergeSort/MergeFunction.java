package mergeSort;

import java.util.Arrays;

/**
 * @author 24412
 */
public class MergeFunction {

    public static void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr,int begin, int end){
        if (end ==  begin)
            return;
        else if (end - begin ==1){
            if (arr[begin] > arr[end])
                change(arr,begin,end);
            return;
        }
        int center = (begin+end)/2;
        mergeSort(arr,begin,center);
        mergeSort(arr,center+1,end);
        merge(arr,begin,center,end);
    }

    private static void merge(int[] arr,int begin,int center, int end){
        int[] a = Arrays.copyOfRange(arr,begin,center+1);
        int[] b = Arrays.copyOfRange(arr,center+1,end+1);
        int[] ret = merge(a,b);
        int j=0;
        for (int i = begin; i <= end; i++) {
            arr[i] = ret[j++];
        }
    }

    public static int[] merge(int[] a,int[] b ){
        int pa = 0;
        int pb = 0;
        int pr = 0;

        int[] ret = new int[a.length+b.length];

        while (pa < a.length || pb < b.length){
            if (pb >= b.length || pa < a.length && a[pa] < b[pb] ){
                ret[pr++] = a[pa++];
            }else {
                ret[pr++] = b[pb++];
            }
        }
        return ret;

    }

    private static void change(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,4,14,9,6,8,12,2,16};
        MergeFunction.mergeSort(arr);
        for (int val: arr
             ) {
            System.out.println(val);
        }
    }

}

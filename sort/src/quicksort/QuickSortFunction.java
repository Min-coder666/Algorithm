package quicksort;

import util.SortUtil;

public class QuickSortFunction {

    public static void quicksort(int[] arr){
        quicksort(arr,0,arr.length-1);
    }

    public static void quicksort(int[] arr,int left, int right){

        if (left >= right-1)
            return;
        int pivot = median3(arr,left,right);
        int i = left;
        int j = right-1;

        while(true){
            while (arr[++i]<pivot){}
            while (arr[--j]>pivot){}
            if (i<j){
                SortUtil.swap(arr,i,j);
            }else {
                break;
            }
        }
        SortUtil.swap(arr,i,right-1);
        quicksort(arr,left,i-1);
        quicksort(arr,i+1,right);
    }


    private static int median3(int[] arr,int left, int right){
        int center = (left+right)/2;
        if (arr[left] > arr[center]){
            SortUtil.swap(arr,left,center);
        }
        if (arr[left] > arr[right]){
            SortUtil.swap(arr,left,right);
        }
        if (arr[center] > arr[right]){
            SortUtil.swap(arr,right,center);
        }
        SortUtil.swap(arr,center,right-1);
        return arr[right-1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,100,1,2,8,7,9,3,12,15,23};
        quicksort(arr);
        for (int val: arr
             ) {
            System.out.println(val);
        }

    }

}

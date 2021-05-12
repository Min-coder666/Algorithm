package mergeSort;

public class StandardMerge {

    public static void mergeSort(int[] arr){
        mergeSort(arr,new int[arr.length],0,arr.length-1);
    }

    public static void mergeSort(int[] arr,int[] temp,int begin,int end){
        if (end > begin){
            int center = (end+begin)/2;
            mergeSort(arr,temp,begin,center);
            mergeSort(arr,temp,center+1,end);
            merge(arr,temp,begin,center,end);
        }
    }

    public static void merge(int[] arr,int[] temp,int left,int center,int right){

        int leftPoint = left;
        int rightPoint = center+1;
        int tempPoint = left;

        while(leftPoint<=center || rightPoint<right){
            if (rightPoint>right || leftPoint<=center && arr[leftPoint] <= arr[rightPoint]){
                temp[tempPoint++] = arr[leftPoint++];
            }else {
                temp[tempPoint++] = arr[rightPoint++];
            }
        }

        while(tempPoint-- > left){
            arr[tempPoint] = temp[tempPoint];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,8,7,6,3,4};
        mergeSort(arr);
        for (int val: arr
             ) {
            System.out.println(val);
        }
    }

}

package test;

/**
 * @author 24412
 */
public class SortFunction{


    public static Comparable[] merge(Comparable[] a,Comparable[] b ){
        int pa = 0;
        int pb = 0;
        int pr = 0;

        Comparable[] ret = new Comparable[a.length+b.length];

        while (pa < a.length || pb < b.length){
            if (pb >= b.length || pa<a.length && a[pa].compareTo(b[pb]) < 0 ){
                ret[pr++] = a[pa++];
            }else {
                ret[pr++] = b[pb++];
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1,3,5,7,9,11,13,15};
        Integer[] arr2 = new Integer[]{2,4,6,8,10};
        Object[] ret = SortFunction.merge(arr1,arr2);
        for (Object val: ret
             ) {
            System.out.println(val);
        }
    }
}

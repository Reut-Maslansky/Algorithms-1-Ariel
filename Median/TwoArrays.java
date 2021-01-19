package Median;

import java.util.Arrays;

public class TwoArrays {;
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 7, 20};
        int[] arr2 = {4, 6, 10, 21};
        System.out.println(Arrays.toString(BiggerThanMedian(arr1, arr2)));
        System.out.println(FindMedian(arr1, arr2));
    }

    static double FindMedian(int[] arr1, int[] arr2) {
        int[] merge = new int[arr1.length + arr2.length];
        int i = 0, j = 0, index = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                merge[index++] = arr1[i++];

             else
                merge[index++] = arr2[j++];

        }
        while (i < arr1.length) {
            merge[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            merge[index++] = arr2[j++];
        }
        System.out.println(Arrays.toString(merge));
        if(merge.length%2==0)
        return merge[merge.length/2] ;
        else return (merge[merge.length/2]+merge[merge.length/2+1])/2;
    }

    static int[] BiggerThanMedian(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int index = 0;
        int i = 0, j = arr2.length - 1;
        while (i < arr1.length) {
            if (arr1[i] < arr2[j])
                ans[index++] = arr2[j];
            else
                ans[index++] = arr1[i];
            j--;
            i++;
        }

        return ans;
    }
}

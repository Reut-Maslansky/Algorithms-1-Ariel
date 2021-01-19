package LIS.special;

import java.util.Arrays;

public class MaxSum {
    public static void main(String[] args) {
        int[] x = {1, 60, 6, 58, 2, 3, 4, 61};
        System.out.println(maxSum(x));
    }

    static int maxSum(int[] arr) {
        int[] value = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && value[j]>max) max=value[j];
            }
            value[i]=max+arr[i];
        }
        int maxValue = 0;
        for(int i=0; i<value.length; i++){
            if(value[i]>maxValue) maxValue=value[i];
        }

        return maxValue;
    }

}

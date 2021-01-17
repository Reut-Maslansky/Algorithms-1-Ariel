package Exams.summer18a;

import java.util.Arrays;

public class q1 {
    public static void main(String[] args) {
        int[] arr = {6, 2, 8, 3, 15, 9};
        int max = LIS(arr);
        int[] maxArr = LISArray(arr);
        System.out.println(max);
    }

    private static int[] LISArray(int[] arr) {

        return null;
    }

    private static int LIS(int[] arr) {
        int[] help = new int[arr.length];
        int index = 0;
        help[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > help[index]) help[++index] = arr[i];
            else {
                int temp = Arrays.binarySearch(help, 0, index, arr[i]);
                if (temp < 0) {
                    temp = -temp - 1;
                    help[temp] = arr[i];
                }

            }
        }

        return index + 1;
    }

    private static int AbsLIS(int[] arr, int k) {
        int[] help = new int[arr.length];
        int index = 0;
        help[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - help[index]) == k)
                help[++index] = arr[i];
            else {
                int ind2 = index;
                int[] help2 = new int[arr.length];
                boolean flag=false;
                while (ind2 >= 0) {
                    if (Math.abs(arr[i] - help[ind2]) == k) {
                        flag=true;
                        for (int j = 0; j < ind2; j++) {
                            help2[j] = help[i];
                        }
                        help2[ind2] = arr[i];
                    }
                    else ind2--;
                }

            }
        }

        return index + 1;
    }

    private static void binarySearchBetween() {
    }

}

package LIS.special;

import java.util.Arrays;

public class Bytes {
    public static void main(String[] args) {
        int[] arr = {0, 5, 8, 3, 11, 7, 9, 61};
        int[] brr = {1, 1, 1, 1, 0, 0, 1, 1};
        int[] x = {1, 7, 9, 50, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] y = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0};

        System.out.println(bytes(arr, brr));
        System.out.println(bytes(x, y));
    }

    static int bytes(int[] arr, int[] brr) {

        int[] ans = new int[arr.length];
        int index = 0;
        int t = 0;
        while (t < brr.length && brr[t] == 0) {
            t++;
        }
        ans[0] = arr[t];
        for (int i = t + 1; i < arr.length; i++) {
            if (brr[i] != 0) {
                if (arr[i] > ans[index]) {
                    ans[++index] = arr[i];
                } else {
                    int temp = Arrays.binarySearch(ans, 0, index, arr[i]);
                    if (temp < 0) temp = -temp - 1;
                    ans[temp] = arr[i];
                }
            }
        }
        return index + 1;
    }
}

package LIS.special;

import java.util.Arrays;

public class UpAndDownn2 {
    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 4, 1, 7, 10, 13, 0};
        System.out.println(upAndDown(arr));
    }

    private static int upAndDown(int[] arr) {
        int[] up = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i]>arr[j] && up[j] > max) max = up[j];
            }
            up[i] = ++max;
        }
        int[] down = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i]>arr[j] && down[j] > max) max = down[j];
            }
            down[i] = ++max;
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (up[i]+down[i]-1>max) max = up[i]+down[i]-1;
        }
        return max;
        }
    }

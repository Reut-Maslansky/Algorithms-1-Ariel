package LIS.special;

import java.util.Arrays;

public class condition {
    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 4, 1, 7, 10, 13, 0};
        System.out.println(dis(arr, 3));
        System.out.println(Arrays.toString(arr(arr, 3)));
    }

    static int dis(int[] arr, int k) {

        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int maxK = 0;
            for (int j = 0; j < i; j++) {
                if (func(arr[i], arr[j], k)) {
                    if (maxK < help[j])
                        maxK = help[j];
                }
            }
            help[i] = maxK + 1;
        }

        //find max help
        int max = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] > max) max = help[i];
        }
        return max;
    }

    static int[] arr(int[] arr, int k) {
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int maxK = 0;
            for (int j = 0; j < i; j++) {
                if (func(arr[i], arr[j], k)) {
                    if (maxK < help[j])
                        maxK = help[j];
                }
            }
            help[i] = maxK + 1;
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] > max) {
                max = help[i];
                index = i;
            }
        }
        int[] ans = new int[max];
        int t = max - 1;
        ans[t--] = arr[index];
        for (int i = index; i > 0;) {
            for (int j = i - 1; j >= 0; j--) {
                if (func(arr[i], arr[j], k) && help[i] - 1 == help[j]) {
                    ans[t--] = arr[j];
                    i = j;
                }
            }
        }
        return ans;
    }

    static boolean func(int x, int y, int k) {
        return Math.abs(x - y) == k;
    }
}
